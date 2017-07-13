package ve.gob.fundelec.simlec.Login;

/**
 * Created by fundelec on 12/07/17.
 */

public interface LoginRepository {
    void login(String type, String user, String password);
}
