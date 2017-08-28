package ve.gob.fundelec.simlec.Reporte;

import ve.gob.fundelec.simlec.Reporte.event.ReportEvent;

/**
 * Created by fundelec on 28/08/17.
 */

public interface ReportPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(ReportEvent event);

}
