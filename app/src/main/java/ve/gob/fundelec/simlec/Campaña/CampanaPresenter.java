package ve.gob.fundelec.simlec.Campaña;


import ve.gob.fundelec.simlec.Campaña.event.CampanaEvent;

/**
 * Created by fundelec on 14/07/17.
 */

public interface CampanaPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(CampanaEvent event);

    void getListMedidores(String recycler);
}
