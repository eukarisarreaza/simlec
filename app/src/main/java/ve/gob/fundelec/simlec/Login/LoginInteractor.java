package ve.gob.fundelec.simlec.Login;

/**
 * Created by fundelec on 12/07/17.
 */

public interface LoginInteractor {
    void login(String type, String user, String password);
    void checkForAuthenticateUser();
}
