package ve.gob.fundelec.simlec.ObjetosConexion;

import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.ObjetosConexion.event.ObjetosConexionEvent;

/**
 * Created by fundelec on 26/07/17.
 */

public interface ObjetosConexionPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(ObjetosConexionEvent event);

    void getInfoRuta();
    void onSelectObjeto(QueryObjetoConexion objeto);

}
