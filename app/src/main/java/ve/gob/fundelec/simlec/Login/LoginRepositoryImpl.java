package ve.gob.fundelec.simlec.Login;

import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Services.ServiceRequest;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 12/07/17.
 */

public class LoginRepositoryImpl implements LoginRepository{
    private EventBus eventBus;
    private ServiceRequest request;
    private LectorSessionManager sessionManager;

    public LoginRepositoryImpl(EventBus eventBus, ServiceRequest request, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.request = request;
        this.sessionManager = sessionManager;
    }
}
