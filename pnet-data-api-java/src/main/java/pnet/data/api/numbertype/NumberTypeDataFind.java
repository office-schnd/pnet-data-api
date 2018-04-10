package pnet.data.api.numbertype;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pnet.data.api.util.AbstractFind;
import pnet.data.api.util.FindFunction;
import pnet.data.api.util.Pair;
import pnet.data.api.util.RestrictMatchcodes;
import pnet.data.api.util.RestrictUpdatedAfter;

public class NumberTypeDataFind extends AbstractFind<NumberTypeItemDTO, NumberTypeDataFind>
    implements RestrictMatchcodes<NumberTypeDataFind>, RestrictUpdatedAfter<NumberTypeDataFind>
{

    public NumberTypeDataFind(ObjectMapper mapper, FindFunction<NumberTypeItemDTO> findFunction,
        List<Pair<String, Object>> restricts)
    {
        super(mapper, findFunction, restricts);
    }

}
