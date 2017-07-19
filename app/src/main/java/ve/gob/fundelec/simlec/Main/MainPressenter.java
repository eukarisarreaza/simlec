package ve.gob.fundelec.simlec.Main;

import ve.gob.fundelec.simlec.Main.event.MainEvent;

/**
 * Created by fundelec on 10/07/17.
 */

public interface MainPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(MainEvent event);

    void getListItenMenu();
    void getInicio();

    void salir();
}
