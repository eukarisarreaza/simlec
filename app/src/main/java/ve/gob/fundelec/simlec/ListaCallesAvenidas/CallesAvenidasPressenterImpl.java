package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.event.CallesAvenidasEvent;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.ui.CallesAvenidasView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 25/07/17.
 */

public class CallesAvenidasPressenterImpl implements CallesAvenidasPressenter{
    private EventBus eventBus;
    private CallesAvenidasView view;
    private CallesAvenidasInteractor interactor;


    public CallesAvenidasPressenterImpl(EventBus eventBus, CallesAvenidasView view, CallesAvenidasInteractor interactor) {
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
    public void onEventMainThread(CallesAvenidasEvent event) {
        switch (event.getEventType()){
            case CallesAvenidasEvent.showListCalles:

                break;
            case CallesAvenidasEvent.showInfoRuta:
                break;
        }
    }

    @Override
    public void getListCalles() {
        this.interactor.getListCalles();
    }
}
