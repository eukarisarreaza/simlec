package ve.gob.fundelec.simlec.ObjetosConexion.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.di.CallesAvenidasModule;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 26/07/17.
 */
@Singleton
@Component(modules = {CallesAvenidasModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface ObjetosConexionComponent {
    void inject();
}
