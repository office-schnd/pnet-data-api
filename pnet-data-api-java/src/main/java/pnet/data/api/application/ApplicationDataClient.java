package pnet.data.api.application;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import at.porscheinformatik.happyrest.GenericType;
import pnet.data.api.PnetDataClientException;
import pnet.data.api.client.DefaultPnetDataClientResultPage;
import pnet.data.api.client.PnetDataClientResultPage;
import pnet.data.api.client.context.AbstractPnetDataApiClient;
import pnet.data.api.client.context.PnetDataApiContext;
import pnet.data.api.util.Pair;

/**
 * Data-API client for {@link ApplicationDataDTO}s.
 *
 * @author cet
 */
@Service
public class ApplicationDataClient extends AbstractPnetDataApiClient<ApplicationDataClient>
{
    public ApplicationDataClient(PnetDataApiContext context)
    {
        super(context);
    }

    public ApplicationDataGet get()
    {
        return new ApplicationDataGet(this::get, null);
    }

    protected PnetDataClientResultPage<ApplicationDataDTO> get(List<Pair<String, Object>> restricts, int pageIndex,
        int itemsPerPage) throws PnetDataClientException
    {
        return invoke(restCall -> {
            DefaultPnetDataClientResultPage<ApplicationDataDTO> resultPage = restCall
                .parameters(restricts)
                .parameter("p", pageIndex)
                .parameter("pp", itemsPerPage)
                .path("/api/v1/applications/details")
                .get(new GenericType.Of<DefaultPnetDataClientResultPage<ApplicationDataDTO>>()
                {
                    // intentionally left blank
                });

            resultPage.setPageSupplier(index -> get(restricts, index, itemsPerPage));

            return resultPage;
        });
    }

    public ApplicationDataSearch search()
    {
        return new ApplicationDataSearch(this::search, null);
    }

    protected PnetDataClientResultPage<ApplicationItemDTO> search(Locale language, String query,
        List<Pair<String, Object>> restricts, int pageIndex, int itemsPerPage) throws PnetDataClientException
    {
        return invoke(restCall -> {
            DefaultPnetDataClientResultPage<ApplicationItemDTO> resultPage = restCall
                .parameter("l", language)
                .parameter("q", query)
                .parameters(restricts)
                .parameter("p", pageIndex)
                .parameter("pp", itemsPerPage)
                .path("/api/v1/applications/search")
                .get(new GenericType.Of<DefaultPnetDataClientResultPage<ApplicationItemDTO>>()
                {
                    // intentionally left blank
                });

            resultPage.setPageSupplier(index -> search(language, query, restricts, index, itemsPerPage));

            return resultPage;
        });
    }

    public ApplicationDataAutoComplete autoComplete()
    {
        return new ApplicationDataAutoComplete(this::autoComplete, null);
    }

    protected List<ApplicationAutoCompleteDTO> autoComplete(Locale language, String query,
        List<Pair<String, Object>> restricts) throws PnetDataClientException
    {
        return invoke(restCall -> restCall
            .parameter("l", language)
            .parameter("q", query)
            .parameters(restricts)
            .path("/api/v1/applications/autocomplete")
            .get(new GenericType.Of<List<ApplicationAutoCompleteDTO>>()
            {
                // intentionally left blank
            }));
    }

    public ApplicationDataFind find()
    {
        return new ApplicationDataFind(this::find, null);
    }

    protected PnetDataClientResultPage<ApplicationItemDTO> find(Locale language, List<Pair<String, Object>> restricts,
        int pageIndex, int itemsPerPage) throws PnetDataClientException
    {
        return invoke(restCall -> {
            DefaultPnetDataClientResultPage<ApplicationItemDTO> resultPage = restCall
                .parameters(restricts)
                .parameter("l", language)
                .parameter("p", pageIndex)
                .parameter("pp", itemsPerPage)
                .path("/api/v1/applications/find")
                .get(new GenericType.Of<DefaultPnetDataClientResultPage<ApplicationItemDTO>>()
                {
                    // intentionally left blank
                });

            resultPage.setPageSupplier(index -> find(language, restricts, index, itemsPerPage));
            resultPage.setScrollSupplier(this::next);

            return resultPage;
        });
    }

    protected PnetDataClientResultPage<ApplicationItemDTO> next(String scrollId) throws PnetDataClientException
    {
        return invoke(restCall -> {
            DefaultPnetDataClientResultPage<ApplicationItemDTO> resultPage = restCall
                .variable("scrollId", scrollId)
                .path("/api/v1/applications/next/{scrollId}")
                .get(new GenericType.Of<DefaultPnetDataClientResultPage<ApplicationItemDTO>>()
                {
                    // intentionally left blank
                });

            resultPage.setScrollSupplier(this::next);

            return resultPage;
        });
    }
}
