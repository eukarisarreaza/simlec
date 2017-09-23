package ve.gob.fundelec.simlec.LecturaGestionar;

import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.LecturaGestionar.event.LecturaGestionarEvent;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarView;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class LecturaGestionarPresenterImpl implements LecturaGestionarPresenter{
    private static final String TAG= LecturaGestionarPresenterImpl.class.getName();
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
                Log.e(TAG, "mostrar datos de notas de lectura ");

                if(view!=null) {
                    view.showListNotas(event.getNotasLectura());
                }
                break;

            case LecturaGestionarEvent.showInfoRuta:
                if(view!=null) {
                    view.showInfoRuta(event.getRuta().getNom_ruta(), "");
                    QueryCalles calle = event.getCalle();
                    view.showDireccion(calle.getMunicipio(), calle.getParroquia(), "", calle.getNom_calle());
                    view.showObjetoConexion(event.getObjetoConexion().getNom_obj_conex());
                    view.showCodObjetoConexion(event.getObjetoConexion().getCod_obj_conex());
                    Log.e(TAG, "posiscion de nota de lectura "+event.getPosNotaLectura());

                    if(event.getPosNotaLectura()!=0)
                        view.showNotaLectura(event.getPosNotaLectura());
                }
                break;

        }
    }



    @Override
    public void onSelectObjeto() {
        interactor.onSelectObjeto();
    }
}
