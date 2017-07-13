package ve.gob.fundelec.simlec.Login;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginInteractorImpl implements LoginInteractor{
    private LoginRepository repository;

    public LoginInteractorImpl(LoginRepository repository) {
        this.repository = repository;
    }


    @Override
    public void login(String type, String user, String password) {
        this.repository.login(type, user, password);
    }
}
