package ve.gob.fundelec.simlec.ObjetosConexion;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ObjetosConexion.event.ObjetosConexionEvent;
import ve.gob.fundelec.simlec.ObjetosConexion.ui.ObjetosConexionView;
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

        }
    }
}
