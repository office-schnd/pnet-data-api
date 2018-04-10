package pnet.data.api.companytype;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pnet.data.api.util.AbstractFind;
import pnet.data.api.util.FindFunction;
import pnet.data.api.util.Pair;
import pnet.data.api.util.RestrictMatchcodes;
import pnet.data.api.util.RestrictTenants;
import pnet.data.api.util.RestrictUpdatedAfter;

/**
 * Find for {@link CompanyTypeDataClient}.
 *
 * @author ham
 */
public class CompanyTypeDataFind extends AbstractFind<CompanyTypeItemDTO, CompanyTypeDataFind>
    implements RestrictMatchcodes<CompanyTypeDataFind>, RestrictTenants<CompanyTypeDataFind>,
    RestrictUpdatedAfter<CompanyTypeDataFind>
{

    public CompanyTypeDataFind(ObjectMapper mapper, FindFunction<CompanyTypeItemDTO> findFunction,
        List<Pair<String, Object>> restricts)
    {
        super(mapper, findFunction, restricts);
    }

}
