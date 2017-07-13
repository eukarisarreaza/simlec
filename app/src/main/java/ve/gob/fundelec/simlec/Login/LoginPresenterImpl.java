package ve.gob.fundelec.simlec.Login;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.Login.event.LoginEvent;
import ve.gob.fundelec.simlec.Login.ui.LoginView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginPresenterImpl implements LoginPresenter{
    private EventBus eventBus;
    private LoginInteractor interactor;
    private LoginView view;

    public LoginPresenterImpl(EventBus eventBus, LoginInteractor interactor, LoginView view) {
        this.eventBus = eventBus;
        this.interactor = interactor;
        this.view = view;
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
            case LoginEvent.onLoginError:
                break;
            case LoginEvent.onLoginSuccess:
                view.showMainActivity();
                break;
        }
    }

    @Override
    public void login(String type, String user, String password) {
        view.showProgressDialogo();
        interactor.login(type, user, password);

    }
}
