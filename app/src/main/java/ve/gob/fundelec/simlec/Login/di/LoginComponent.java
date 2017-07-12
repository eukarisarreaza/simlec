package ve.gob.fundelec.simlec.Login.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Login.ui.LoginActivity;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 12/07/17.
 */
@Singleton
@Component(modules = {LibsModule.class, LoginModule.class, ServiceModule.class, SesionModule.class, ContextModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
