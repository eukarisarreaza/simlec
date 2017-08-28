package ve.gob.fundelec.simlec.Reporte;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportRepositoryImpl implements ReportRepository {
    private EventBus eventBus;
    private LectorSessionManager sessionManager;


    public ReportRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }




}
