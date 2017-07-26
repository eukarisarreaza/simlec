package ve.gob.fundelec.simlec.ObjetosConexion;

import ve.gob.fundelec.simlec.ObjetosConexion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public interface ObjetosConexionRepository {

    void getRuta();
    void getInfoCalle();

    void getListObjetosConexion();
    void onSelectObjeto(QueryObjetoConexion objeto);

}
