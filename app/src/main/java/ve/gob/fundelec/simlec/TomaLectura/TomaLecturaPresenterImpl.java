package ve.gob.fundelec.simlec.TomaLectura;

import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;
import ve.gob.fundelec.simlec.TomaLectura.ui.TomaLecturaView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaPresenterImpl implements TomaLecturaPresenter {
    private EventBus eventBus;
    private TomaLecturaView view;
    private TomaLecturaInteractor interactor;
    private static final String TAG= TomaLecturaPresenterImpl.class.getName();

    public TomaLecturaPresenterImpl(EventBus eventBus, TomaLecturaView view, TomaLecturaInteractor interactor) {
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
    public void onEventMainThread(TomaLecturaEvent event) {
        switch (event.getEventType()){
            case TomaLecturaEvent.onFailedGrabarNota:
                break;
            case TomaLecturaEvent.onSussesGrabarNota:
                break;


            case TomaLecturaEvent.showInfoRuta:
                if(view!=null) {
                    view.showInfoRuta(event.getRuta().getNom_ruta(), "");
                    view.showEmplazamiento(event.getObjetoConexion().getEmplazamiento());
                }
                break;

            case TomaLecturaEvent.showListNotas:
                if(view!=null)
                    view.showNotaLectura(event.getNotasLectura());

                break;
            case TomaLecturaEvent.showInfoMedidor:
                if(view!=null) {
                    view.showNumMedidor(event.getMedidor().getNumero());
                    view.showNotaLectura(event.getPosNotaLectura());
                    view.setNumeroDecimalesEnteros(event.getMedidor().getDig_entero(), event.getMedidor().getDig_decimal());
                }
                break;
            case TomaLecturaEvent.showInfoIndicadorLectura:
                if(view!=null) {
                    view.showLectura1(event.getKva());
                    view.showLectura2(event.getVa());
                }
                break;
            case TomaLecturaEvent.saveLectura:
                if(view!=null)
                    interactor.saveLectura(view.getLectura1(), view.getLectura2());
                break;
            case TomaLecturaEvent.onFailedGrabarLcetura:
                if(view!=null)
                    view.onFailedGrabarLectura();
                break;
            case TomaLecturaEvent.onSussesGrabarLectura:
                if(view!=null)
                    view.onSuccesGrabarLectura();
                break;
        }
    }

    @Override
    public void getNotasTomaLectura() {
        interactor.getNotasLectura();
    }

    @Override
    public void getInfoRuta() {
        interactor.getInfoRuta();
    }

    @Override
    public void grabarNota(int post) {
        interactor.grabarNotaLectura(post);
    }

    @Override
    public void grabarLectura(String lectura) {
        //interactor.grabarLectura(lectura);
    }

    @Override
    public void getParametrosLectura() {
        interactor.getParametrosLectura();
    }
}
