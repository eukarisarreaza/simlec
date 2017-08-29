package ve.gob.fundelec.simlec.Reporte;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 28/08/17.
 */

public interface ReportInteractor {
    void getListRutas();
    void onSelectCalle(QueryCalles calle);
}
