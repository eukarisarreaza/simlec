package ve.gob.fundelec.simlec.ListaRutasAsignadas.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.ui.RutasAsignadasFragment;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 19/07/17.
 */
@Singleton
@Component(modules = {RutasAsignadasModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface RutasAsignadasComponent {
    void inject(RutasAsignadasFragment fragment);
}
