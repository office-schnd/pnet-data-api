package pnet.data.api.util;

import java.util.List;
import java.util.Locale;

import pnet.data.api.PnetDataClientException;
import pnet.data.api.client.PnetDataClientResultPage;

/**
 * Abstract implementation of a find query.
 *
 * @author ham
 * @param <DTO> the type of the DTO
 * @param <SELF> the type of the restriction itself for fluent interface
 */
public abstract class AbstractScrollableFind<DTO, SELF extends AbstractScrollableFind<DTO, SELF>>
    extends AbstractFind<DTO, SELF> implements ScrollableFind<DTO>
{
    protected AbstractScrollableFind(FindFunction<DTO> findFunction, List<Pair<String, Object>> restricts)
    {
        super(findFunction, restricts);
    }

    @Override
    public PnetDataClientResultPage<DTO> executeAndScroll(Locale language, int itemsPerPage)
        throws PnetDataClientException
    {
        return restrict("scroll", true).execute(language, 0, itemsPerPage);
    }
}
