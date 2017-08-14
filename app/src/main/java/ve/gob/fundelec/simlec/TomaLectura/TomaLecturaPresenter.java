package ve.gob.fundelec.simlec.TomaLectura;

import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;

/**
 * Created by fundelec on 10/08/17.
 */

public interface TomaLecturaPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(TomaLecturaEvent event);
    void getNotasTomaLectura();
    void getInfoRuta();
    void grabarNota(int post);
    void grabarLectura(String lectura);
}

