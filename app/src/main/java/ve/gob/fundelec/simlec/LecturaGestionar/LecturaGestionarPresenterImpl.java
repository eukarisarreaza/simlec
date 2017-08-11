package ve.gob.fundelec.simlec.LecturaGestionar;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.LecturaGestionar.event.LecturaGestionarEvent;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarView;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class LecturaGestionarPresenterImpl implements LecturaGestionarPresenter{
    private EventBus eventBus;
    private LecturaGestionarView view;
    private LecturaGestionarInteractor interactor;

    public LecturaGestionarPresenterImpl(EventBus eventBus, LecturaGestionarView view, LecturaGestionarInteractor interactor) {
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

    @Override
    public void getListNotasLecturas() {
        interactor.getListNotasLectura();
    }

    @Override
    public void grabarNotaUnidadLectura(int pos) {
        interactor.grabarNotaLectura(pos);
    }

    @Subscribe
    @Override
    public void onEventMainThread(LecturaGestionarEvent event) {
        switch (event.getEventType()){
            case LecturaGestionarEvent.onFailedGrabarNota:

                break;
            case LecturaGestionarEvent.onSussesGrabarNota:

                break;
            case LecturaGestionarEvent.showListNotas:
                view.showListNotas(event.getNotasLectura());
                break;
            case LecturaGestionarEvent.showInfoRuta:
                view.showInfoRuta(event.getRuta().getNom_ruta(), "");
                QueryCalles calle=event.getCalle();
                view.showDireccion(calle.getMunicipio(), calle.getParroquia(), "", calle.getNom_calle());
                view.showObjetivoConexion(event.getObjetoConexion().getNom_obj_conex());
                break;
        }
    }
}
