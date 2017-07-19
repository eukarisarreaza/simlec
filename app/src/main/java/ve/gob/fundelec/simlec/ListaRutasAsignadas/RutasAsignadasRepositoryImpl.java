package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasRepositoryImpl implements RutasAsignadasRepository{
    private EventBus eventBus;
    private LectorSessionManager sessionManager;

    public RutasAsignadasRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }

    @Override
    public void getListRutasAsignadsas() {

    }

    @Override
    public void getListRutasBloquedas() {

    }

    @Override
    public void getInfoUser() {

    }

    @Override
    public void getVersionApp() {

    }
}
