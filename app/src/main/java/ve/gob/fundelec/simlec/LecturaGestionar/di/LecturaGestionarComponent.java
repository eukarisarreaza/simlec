package ve.gob.fundelec.simlec.LecturaGestionar.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarFragment;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 10/08/17.
 */
@Singleton
@Component(modules = {LecturaGestionarModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface LecturaGestionarComponent {
    void inject(LecturaGestionarFragment fragment);
}
