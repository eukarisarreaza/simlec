package ve.gob.fundelec.simlec.Login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Login.LoginInteractor;
import ve.gob.fundelec.simlec.Login.LoginInteractorImpl;
import ve.gob.fundelec.simlec.Login.LoginPresenter;
import ve.gob.fundelec.simlec.Login.LoginPresenterImpl;
import ve.gob.fundelec.simlec.Login.LoginRepository;
import ve.gob.fundelec.simlec.Login.LoginRepositoryImpl;
import ve.gob.fundelec.simlec.Login.ui.LoginView;
import ve.gob.fundelec.simlec.Services.ServiceRequest;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 12/07/17.
 */
@Module
public class LoginModule {
    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginInteractor interactor){
        return new LoginPresenterImpl(eventBus, interactor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository){
        return new LoginInteractorImpl(repository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, ServiceRequest request, LectorSessionManager sessionManager){
        return new LoginRepositoryImpl(eventBus, request, sessionManager);
    }

    @Provides
    @Singleton
    LoginView providesLoginView(){
        return this.view;
    }

}
