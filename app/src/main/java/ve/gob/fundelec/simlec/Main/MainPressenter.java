package ve.gob.fundelec.simlec.Main;

import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.Main.event.RecorridoEvent;

/**
 * Created by fundelec on 10/07/17.
 */

public interface MainPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(MainEvent event);
    void onEventRecorrido(RecorridoEvent event);

    void getListItenMenu();
    void getInicio();

    void salir();
}
