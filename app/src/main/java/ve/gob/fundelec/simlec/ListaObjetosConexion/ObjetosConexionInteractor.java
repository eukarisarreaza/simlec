package ve.gob.fundelec.simlec.ListaObjetosConexion;

import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public interface ObjetosConexionInteractor {
    void getInfoRuta();
    void getListObjetosConexion();
    void onSelectObjeto(QueryObjetoConexion objeto);
}
