package pnet.data.api.util;

/**
 * Restricts external brands.
 *
 * @author ham
 * @param <SELF> the type of the restrict for chaining
 */
public interface RestrictExternalBrands<SELF extends Restrict<SELF>> extends Restrict<SELF>
{

    default SELF externalBrand(String... externalBrandMatchcodes)
    {
        return restrict("externalBrand", (Object[]) externalBrandMatchcodes);
    }

}
