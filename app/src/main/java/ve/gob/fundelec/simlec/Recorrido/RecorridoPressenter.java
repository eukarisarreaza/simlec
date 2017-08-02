package ve.gob.fundelec.simlec.Recorrido;

import ve.gob.fundelec.simlec.Recorrido.event.LecturasEvent;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LecturasEvent event);
    void getFragmentInicio();

    void registrarFragment();
}
