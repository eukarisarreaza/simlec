package ve.gob.fundelec.simlec.Main.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.Main.ui.MainActivity;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 10/07/17.
 */
@Singleton
@Component(modules = {LibsModule.class, MainModule.class, SesionModule.class, ContextModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
