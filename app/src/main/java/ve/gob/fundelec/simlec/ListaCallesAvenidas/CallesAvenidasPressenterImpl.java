package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
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
                if(view!=null)
                    view.showListCalles(event.getListCallesAv());
                break;
            case CallesAvenidasEvent.showInfoRuta:
                if(view!=null)
                    view.showInfoRuta(event.getRuta().getNom_ruta(), "");
                break;
        }
    }

    @Override
    public void getInfoRuta() {
        interactor.getInfoRuta();
    }

    @Override
    public void getListCalles() {
        this.interactor.getListCalles();
    }

    @Override
    public void onClickCalle(QueryCalles item) {
        interactor.onClickCalle(item);
    }
}
