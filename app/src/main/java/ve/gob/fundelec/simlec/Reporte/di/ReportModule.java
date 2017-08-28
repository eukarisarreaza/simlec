package ve.gob.fundelec.simlec.Reporte.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Reporte.ReportInteractor;
import ve.gob.fundelec.simlec.Reporte.ReportInteractorImpl;
import ve.gob.fundelec.simlec.Reporte.ReportPresenter;
import ve.gob.fundelec.simlec.Reporte.ReportPresenterImpl;
import ve.gob.fundelec.simlec.Reporte.ReportRepository;
import ve.gob.fundelec.simlec.Reporte.ReportRepositoryImpl;
import ve.gob.fundelec.simlec.Reporte.ui.ReportView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 28/08/17.
 */
@Module
public class ReportModule {
    private ReportView view;

    public ReportModule(ReportView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    ReportPresenter providesReportPresenter(EventBus eventBus, ReportView view, ReportInteractor interactor){
        return new ReportPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    ReportInteractor providesReportInteractor(ReportRepository reportRepository){
        return new ReportInteractorImpl(reportRepository);
    }

    @Provides
    @Singleton
    ReportRepository providesReportRepository(EventBus eventBus, LectorSessionManager sessionManager){
        return new ReportRepositoryImpl(eventBus, sessionManager);
    }

    @Provides
    @Singleton
    ReportView providesReportView(){
        return this.view;
    }

}
