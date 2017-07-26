package ve.gob.fundelec.simlec.ObjetosConexion;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.ObjetosConexion.event.ObjetosConexionEvent;
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
        ObjetosConexionEvent event= new ObjetosConexionEvent();
        event.setRuta(sessionManager.getRuta());
        eventBus.post(event);
    }

    @Override
    public void getInfoCalle() {
        ObjetosConexionEvent event= new ObjetosConexionEvent();
        event.setCalles(sessionManager.getCalle());
        eventBus.post(event);
    }

    @Override
    public void getListObjetosConexion() {


        /**
        ObjetosConexionEvent event= new ObjetosConexionEvent();
        event.setLista();
        eventBus.post(event);
         */
    }

    @Override
    public void onSelectObjeto(QueryObjetoConexion objeto) {

    }

}
