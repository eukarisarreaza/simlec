package ve.gob.fundelec.simlec.LecturaGestionar;

import ve.gob.fundelec.simlec.LecturaGestionar.event.LecturaGestionarEvent;

/**
 * Created by fundelec on 10/08/17.
 */

public interface LecturaGestionarPresenter {
    void onCreate();
    void onDestroy();
    void getListNotasLecturas();
    void grabarNotaUnidadLectura(int pos);
    void onEventMainThread(LecturaGestionarEvent event);

    void onSelectObjeto();
}
