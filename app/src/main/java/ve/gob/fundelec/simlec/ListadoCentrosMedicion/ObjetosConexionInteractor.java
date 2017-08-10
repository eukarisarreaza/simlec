package ve.gob.fundelec.simlec.ListadoCentrosMedicion;

import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public interface ObjetosConexionInteractor {
    void getInfoRuta();
    void getListObjetosConexion();
    void onSelectObjeto(QueryObjetoConexion objeto);
}
