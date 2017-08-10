package ve.gob.fundelec.simlec.ListadoCentrosMedicion;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.event.ObjetosConexionEvent;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ui.ObjetosConexionView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 26/07/17.
 */

public class ObjetosConexionPressenterImpl implements ObjetosConexionPressenter {
    private EventBus eventBus;
    private ObjetosConexionView view;
    private ObjetosConexionInteractor interactor;

    public ObjetosConexionPressenterImpl(EventBus eventBus, ObjetosConexionView view, ObjetosConexionInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(ObjetosConexionEvent event) {
        switch (event.getEventType()){
            case ObjetosConexionEvent.showInfoCalle:
                /**  PROGRESO Y UNIDAD DE LECTURA  */
                view.showInfoCalle(event.getCalles().getNom_calle(),
                        event.getCalles().getCant_lect_gestionadasŗ()+"/"+event.getCalles().getCant_lect_progr());
                break;
            case ObjetosConexionEvent.showInfoRuta:
                view.showInfoRuta(event.getRuta().getNom_ruta(), "");
                break;
            case ObjetosConexionEvent.showListasObjetos:
                view.showListObjetosConexion(event.getLista());
                break;
        }
    }

    @Override
    public void getInfoRuta() {
        interactor.getInfoRuta();
    }

    @Override
    public void getListObjetosConexion() {
        interactor.getListObjetosConexion();
    }

    @Override
    public void onSelectObjeto(QueryObjetoConexion objeto) {
        interactor.onSelectObjeto(objeto);
    }

}
