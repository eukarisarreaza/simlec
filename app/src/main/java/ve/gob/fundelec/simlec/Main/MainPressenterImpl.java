package ve.gob.fundelec.simlec.Main;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.Main.ui.MainView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainPressenterImpl implements MainPressenter {
    private EventBus eventBus;
    private MainView view;
    private MainIteractor iteractor;


    public MainPressenterImpl(EventBus eventBus, MainView view, MainIteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.iteractor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view=null;
    }

    @Subscribe
    @Override
    public void onEventMainThread(MainEvent event) {
        switch (event.getEventType()){
            case MainEvent.onBackPress:
                break;
            case MainEvent.onButtonMenu:
                break;
            case MainEvent.onClickPresinto:
                break;
            case MainEvent.onClickSobrante:
                break;
            case MainEvent.onSearch:
                break;

        }
    }

    @Override
    public void getListItenMenu() {
        iteractor.getListMenu();
    }

    @Override
    public void getInicio() {
        iteractor.getInicio();
    }

}
