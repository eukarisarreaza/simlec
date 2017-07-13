package ve.gob.fundelec.simlec.Login;

import ve.gob.fundelec.simlec.Login.event.LoginEvent;

/**
 * Created by fundelec on 12/07/17.
 */

public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);

    void login(String type, String user, String password);

    void checkForAuthenticateUser();
}
