package ve.gob.fundelec.simlec.ListadoCentrosMedicion;

import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.event.ObjetosConexionEvent;

/**
 * Created by fundelec on 26/07/17.
 */

public interface ObjetosConexionPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(ObjetosConexionEvent event);

    void getInfoRuta();
    void getListObjetosConexion();
    void onSelectObjeto(QueryObjetoConexion objeto);

}
