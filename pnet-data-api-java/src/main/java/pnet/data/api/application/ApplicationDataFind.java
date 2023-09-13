package pnet.data.api.application;

import java.util.List;

import pnet.data.api.util.AbstractFind;
import pnet.data.api.util.FindFunction;
import pnet.data.api.util.IncludeInactive;
import pnet.data.api.util.Pair;
import pnet.data.api.util.RestrictMatchcode;
import pnet.data.api.util.RestrictUpdatedAfter;
import pnet.data.api.util.Scrollable;

/**
 * Find for applications
 */
public class ApplicationDataFind extends AbstractFind<ApplicationItemDTO, ApplicationDataFind>
    implements RestrictMatchcode<ApplicationDataFind>, RestrictUpdatedAfter<ApplicationDataFind>,
    IncludeInactive<ApplicationDataFind>, Scrollable<ApplicationDataFind>
{
    public ApplicationDataFind(FindFunction<ApplicationItemDTO> searchFunction, List<Pair<String, Object>> restricts)
    {
        super(searchFunction, restricts);
    }
}
