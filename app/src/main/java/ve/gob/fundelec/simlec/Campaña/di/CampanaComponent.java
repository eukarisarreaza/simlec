package ve.gob.fundelec.simlec.Campaña.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Campaña.ui.CampanaFragment;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 14/07/17.
 */
@Singleton
@Component(modules = {CampanaModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface CampanaComponent {
    void inject(CampanaFragment fragment);
}
