package ve.gob.fundelec.simlec.ListadoCentrosMedicion.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ui.ObjetosConexionFragment;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 26/07/17.
 */
@Singleton
@Component(modules = {ObjetosConexionModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface ObjetosConexionComponent {
    void inject(ObjetosConexionFragment fragment);
}
