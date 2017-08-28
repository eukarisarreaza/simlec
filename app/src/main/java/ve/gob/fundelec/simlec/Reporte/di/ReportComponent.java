package ve.gob.fundelec.simlec.Reporte.di;

import javax.inject.Singleton;

import dagger.Component;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.Reporte.ui.ReporteFragment;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 28/08/17.
 */
@Singleton
@Component(modules = {ReportModule.class, LibsModule.class, SesionModule.class, ContextModule.class})
public interface ReportComponent {
    void inject(ReporteFragment fragment);
}
