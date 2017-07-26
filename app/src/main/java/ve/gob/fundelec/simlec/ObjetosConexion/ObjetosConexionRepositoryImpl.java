package ve.gob.fundelec.simlec.ObjetosConexion;

import java.util.List;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 26/07/17.
 */

public class ObjetosConexionRepositoryImpl implements ObjetosConexionRepository {
    private LectorSessionManager sessionManager;
    private EventBus eventBus;

    public ObjetosConexionRepositoryImpl(LectorSessionManager sessionManager, EventBus eventBus) {
        this.sessionManager = sessionManager;
        this.eventBus = eventBus;
    }

    @Override
    public void getRuta() {

    }

    @Override
    public void getCalleAvenidas() {

    }

    @Override
    public void getListObjetosConexion() {

    }

    @Override
    public void voidSelectObjetoConexion() {

    }

    private void postEvent(int type, List<QueryObjetoConexion> list){



    }
}
