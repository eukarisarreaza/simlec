package ve.gob.fundelec.simlec.Login;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.Login.event.LoginEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginPresenterImpl implements LoginPresenter{
    private EventBus eventBus;
    private LoginInteractor interactor;

    public LoginPresenterImpl(EventBus eventBus, LoginInteractor interactor) {
        this.eventBus = eventBus;
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
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()){

        }
    }

    @Override
    public void login(String type, String user, String password) {

    }
}
