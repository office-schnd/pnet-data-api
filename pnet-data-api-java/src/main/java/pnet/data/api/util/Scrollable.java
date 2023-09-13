package pnet.data.api.util;

/**
 * Enables scrolling.
 *
 * @author ham
 * @param <SELF> the type of the restrict for chaining
 * @deprecated Use {@link ScrollableFind}, {@link ScrollableSearch}, {@link ScrollableGet} instead
 */
@Deprecated
public interface Scrollable<SELF extends Restrict<SELF>> extends Restrict<SELF>
{
    /**
     * Enables scrolling.
     *
     * @return the instance for chaining
     * @deprecated use executeAndScroll(..) instead
     */
    @Deprecated
    default SELF scroll()
    {
        return restrict("scroll", true);
    }
}
