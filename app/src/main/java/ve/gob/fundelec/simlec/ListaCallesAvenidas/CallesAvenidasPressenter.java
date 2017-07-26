package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.event.CallesAvenidasEvent;

/**
 * Created by fundelec on 25/07/17.
 */

public interface CallesAvenidasPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(CallesAvenidasEvent event);

    void getListCalles();
    void onClickCalle(QueryCalles item);
}
