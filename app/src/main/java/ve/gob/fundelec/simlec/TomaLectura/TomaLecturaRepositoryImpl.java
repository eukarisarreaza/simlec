package ve.gob.fundelec.simlec.TomaLectura;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaRepositoryImpl implements TomaLecturaRepository{
    private EventBus eventBus;
    private LectorSessionManager sessionManager;


    public TomaLecturaRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }





}
