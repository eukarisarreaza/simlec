package ve.gob.fundelec.simlec.Reporte.di;

import dagger.Module;
import ve.gob.fundelec.simlec.Reporte.ui.ReportView;

/**
 * Created by fundelec on 28/08/17.
 */
@Module
public class ReportModule {
    private ReportView view;

    public ReportModule(ReportView view) {
        this.view = view;
    }



}
