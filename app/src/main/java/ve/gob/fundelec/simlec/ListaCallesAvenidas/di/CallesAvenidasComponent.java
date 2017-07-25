package ve.gob.fundelec.simlec.ListaCallesAvenidas.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.ui.CallesAvenidasFragment;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 25/07/17.
 */
@Singleton
@Component(modules = {LibsModule.class, CallesAvenidasModule.class, SesionModule.class, ContextModule.class})
public interface CallesAvenidasComponent {
    void inject(CallesAvenidasFragment fragment);
}
