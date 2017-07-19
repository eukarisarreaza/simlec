package ve.gob.fundelec.simlec.Main;

import ve.gob.fundelec.simlec.LectorSessionManager;

/**
 * Created by fundelec on 19/07/17.
 */

public class UserRepositoryImpl implements UserRepository{
    private LectorSessionManager sessionManager;

    public UserRepositoryImpl(LectorSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void logout() {
        this.sessionManager.logout();


    }
}
