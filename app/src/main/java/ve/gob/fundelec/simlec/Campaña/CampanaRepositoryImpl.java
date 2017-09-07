package ve.gob.fundelec.simlec.Campaña;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 14/07/17.
 */

public class CampanaRepositoryImpl implements CampanaRepository {
    private EventBus eventBus;
    private LectorSessionManager sessionManager;

    public CampanaRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }




}
