package pnet.data.api.company;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import at.porscheinformatik.happyrest.GenericType;
import pnet.data.api.PnetDataApiException;
import pnet.data.api.client.DefaultPnetDataClientResultPage;
import pnet.data.api.client.PnetDataClientResultPage;
import pnet.data.api.client.context.AbstractPnetDataApiClient;
import pnet.data.api.client.context.PnetDataApiContext;
import pnet.data.api.util.GetById;
import pnet.data.api.util.Pair;

/**
 * Data-API client for {@link CompanyDataDTO}s.
 */
@Service
public class CompanyDataClient extends AbstractPnetDataApiClient<CompanyDataClient> implements GetById<CompanyDataDTO>
{

    public CompanyDataClient(ObjectMapper mapper, PnetDataApiContext context)
    {
        super(mapper, context);
    }

    @Override
    public PnetDataClientResultPage<CompanyDataDTO> getAllByIds(List<Integer> ids, int pageIndex, int itemsPerPage)
        throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("id", ids)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> getAllByIds(ids, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataDTO getByVatIdNumber(String vatIdNumber) throws PnetDataApiException
    {
        return getAllByVatIdNumbers(Arrays.asList(vatIdNumber), 0, 1).first();
    }

    public PnetDataClientResultPage<CompanyDataDTO> getAllByVatIdNumbers(List<String> vatIdNumbers, int pageIndex,
        int itemsPerPage) throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("vatIdNumber", vatIdNumbers)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> getAllByVatIdNumbers(vatIdNumbers, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataDTO getBySapNumber(String sapNumber) throws PnetDataApiException
    {
        return getAllBySapNumbers(Arrays.asList(sapNumber), 0, 1).first();
    }

    public PnetDataClientResultPage<CompanyDataDTO> getAllBySapNumbers(List<String> sapNumbers, int pageIndex,
        int itemsPerPage) throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("sapNumber", sapNumbers)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> getAllBySapNumbers(sapNumbers, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataDTO getByCompanyNumber(String companyNumber) throws PnetDataApiException
    {
        return getAllByCompanyNumbers(Arrays.asList(companyNumber), 0, 1).first();
    }

    public PnetDataClientResultPage<CompanyDataDTO> getAllByCompanyNumbers(List<String> companyNumbers, int pageIndex,
        int itemsPerPage) throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("companyNumber", companyNumbers)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> getAllByCompanyNumbers(companyNumbers, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataDTO getByIban(String iban) throws PnetDataApiException
    {
        return getAllByIbans(Arrays.asList(iban), 0, 1).first();
    }

    public PnetDataClientResultPage<CompanyDataDTO> getAllByIbans(List<String> ibans, int pageIndex, int itemsPerPage)
        throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("iban", ibans)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> getAllByIbans(ibans, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataDTO getByEmail(String email) throws PnetDataApiException
    {
        return getAllByEmails(Arrays.asList(email), 0, 1).first();
    }

    public PnetDataClientResultPage<CompanyDataDTO> getAllByEmails(List<String> emails, int pageIndex, int itemsPerPage)
        throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("email", emails)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> getAllByEmails(emails, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataDTO getByDataProcessingRegisterNumber(String dataProcessingRegisterNumber)
        throws PnetDataApiException
    {
        return getAllByDataProcessingRegisterNumbers(Arrays.asList(dataProcessingRegisterNumber), 0, 1).first();
    }

    public PnetDataClientResultPage<CompanyDataDTO> getAllByDataProcessingRegisterNumbers(
        List<String> dataProcessingRegisterNumbers, int pageIndex, int itemsPerPage) throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyDataDTO> resultPage = createRestCall() //
            .parameters("dataProcessingRegisterNumber", dataProcessingRegisterNumbers)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/details", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyDataDTO>>()
            {
            });

        resultPage.setNextPageSupplier(
            () -> getAllByDataProcessingRegisterNumbers(dataProcessingRegisterNumbers, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataSearch search()
    {
        return new CompanyDataSearch(getMapper(), this::search, null);
    }

    protected PnetDataClientResultPage<CompanyItemDTO> search(Locale language, String query,
        List<Pair<String, Object>> restricts, int pageIndex, int itemsPerPage) throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyItemDTO> resultPage = createRestCall()
            .parameter("l", language)
            .parameter("q", query)
            .parameters(restricts)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/search", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyItemDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> search(language, query, restricts, pageIndex + 1, itemsPerPage));

        return resultPage;
    }

    public CompanyDataFind find()
    {
        return new CompanyDataFind(getMapper(), this::find, null);
    }

    protected PnetDataClientResultPage<CompanyItemDTO> find(Locale language, List<Pair<String, Object>> restricts,
        int pageIndex, int itemsPerPage) throws PnetDataApiException
    {
        DefaultPnetDataClientResultPage<CompanyItemDTO> resultPage = createRestCall()
            .parameters(restricts)
            .parameter("l", language)
            .parameter("p", pageIndex)
            .parameter("pp", itemsPerPage)
            .get("/api/v1/companies/find", new GenericType.Of<DefaultPnetDataClientResultPage<CompanyItemDTO>>()
            {
            });

        resultPage.setNextPageSupplier(() -> find(language, restricts, pageIndex + 1, itemsPerPage));

        return resultPage;
    }
}
