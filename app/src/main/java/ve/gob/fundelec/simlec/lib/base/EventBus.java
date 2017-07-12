package ve.gob.fundelec.simlec.lib.base;

/**
 * Created by root on 01/03/17.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
    void postSticky(Object event);

}
