package ve.gob.fundelec.simlec.TomaLectura;

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
                view.showInfoRuta(event.getRuta().getNom_ruta(), "");
                view.showEmplazamiento(event.getObjetoConexion().getEmplazamiento());
                break;
            case TomaLecturaEvent.showListNotas:
                view.showNotaLectura(event.getNotasLectura());
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
