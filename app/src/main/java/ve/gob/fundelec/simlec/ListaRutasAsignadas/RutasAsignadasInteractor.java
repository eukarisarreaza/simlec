package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;

/**
 * Created by fundelec on 19/07/17.
 */

public interface RutasAsignadasInteractor {
    void getInfoUser();
    void getListRutas();
    void getUltimoInicio();
    void getVersionApp();
    void onClickRuta(QueryRutas ruta);

    void registerHistory();
}
