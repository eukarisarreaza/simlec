package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 25/07/17.
 */

public interface CallesAvenidasInteractor {
    void getListCalles();
    void onClickCalle(QueryCalles item);
    void getInfoRuta();
}
