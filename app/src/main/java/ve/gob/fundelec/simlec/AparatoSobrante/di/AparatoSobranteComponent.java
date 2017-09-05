package ve.gob.fundelec.simlec.AparatoSobrante.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.AparatoSobrante.ui.AparatoSobranteFragment;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.LoginModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.Services.di.ServiceModule;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 14/07/17.
 */


@Singleton
@Component(modules = {LibsModule.class, AparatoSobranteModule.class, SesionModule.class, ContextModule.class})
public interface AparatoSobranteComponent {
    void inject(AparatoSobranteFragment fragment);
}
