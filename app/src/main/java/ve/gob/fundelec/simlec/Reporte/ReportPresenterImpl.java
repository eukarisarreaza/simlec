package ve.gob.fundelec.simlec.Reporte;

import org.greenrobot.eventbus.Subscribe;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.Reporte.event.ReportEvent;
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

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(ReportEvent event) {
        switch (event.getEventType()){
            case ReportEvent.showListRutas:
                if(view!=null){
                    view.showListRutas(event.getHeader(), event.getListDataChild());
                }
                break;
            case ReportEvent.showReport:
                view.showReport(event.getyData());
                break;
            case ReportEvent.onError:
                if(view!=null)
                    view.showError(event.getMessage());
                break;
        }
    }

    @Override
    public void getListRutas() {
        interactor.getListRutas();
    }

    @Override
    public void onSelectCalle(QueryCalles calle) {
        interactor.onSelectCalle(calle);
    }
}
