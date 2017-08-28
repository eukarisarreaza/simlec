package ve.gob.fundelec.simlec.Reporte;

import ve.gob.fundelec.simlec.Reporte.ui.ReportView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportPresenterImpl implements ReportPresenter{
    private EventBus eventBus;
    private ReportView view;
    private ReportInteractor interactor;

    public ReportPresenterImpl(EventBus eventBus, ReportView view, ReportInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }
}
