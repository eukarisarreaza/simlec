package ve.gob.fundelec.simlec.TomaLectura.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.TomaLectura.ui.MedidorFragment;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 10/08/17.
 */
@Singleton
@Component(modules = {TomaLecturaModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface TomaLecturaComponent {
    void inject(MedidorFragment fragment);
}
