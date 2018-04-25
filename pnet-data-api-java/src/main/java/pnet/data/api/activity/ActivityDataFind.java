package pnet.data.api.activity;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pnet.data.api.util.AbstractFind;
import pnet.data.api.util.FindFunction;
import pnet.data.api.util.Pair;
import pnet.data.api.util.RestrictBrand;
import pnet.data.api.util.RestrictCompanyType;
import pnet.data.api.util.RestrictContractType;
import pnet.data.api.util.RestrictMatchcode;
import pnet.data.api.util.RestrictTenant;
import pnet.data.api.util.RestrictUpdatedAfter;

/**
 * Find for {@link ActivityDataClient}.
 *
 * @author ham
 */
public class ActivityDataFind extends AbstractFind<ActivityItemDTO, ActivityDataFind>
    implements RestrictMatchcode<ActivityDataFind>, RestrictTenant<ActivityDataFind>, RestrictBrand<ActivityDataFind>,
    RestrictCompanyType<ActivityDataFind>, RestrictContractType<ActivityDataFind>,
    RestrictUpdatedAfter<ActivityDataFind>
{

    public ActivityDataFind(ObjectMapper mapper, FindFunction<ActivityItemDTO> findFunction,
        List<Pair<String, Object>> restricts)
    {
        super(mapper, findFunction, restricts);
    }

}
