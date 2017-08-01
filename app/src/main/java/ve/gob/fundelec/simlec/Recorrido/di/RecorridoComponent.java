package ve.gob.fundelec.simlec.Recorrido.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.Recorrido.ui.TabFragment;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 01/08/17.
 */
@Singleton
@Component(modules = {RecorridoModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface RecorridoComponent {
    void inject(TabFragment fragment);
}
