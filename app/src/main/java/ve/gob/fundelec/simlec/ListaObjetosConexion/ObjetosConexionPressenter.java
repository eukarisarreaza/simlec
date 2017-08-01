package ve.gob.fundelec.simlec.ListaObjetosConexion;

import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.ListaObjetosConexion.event.ObjetosConexionEvent;

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
