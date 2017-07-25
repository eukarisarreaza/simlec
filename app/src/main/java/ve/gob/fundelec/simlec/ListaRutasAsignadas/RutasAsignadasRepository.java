package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;

/**
 * Created by fundelec on 19/07/17.
 */

public interface RutasAsignadasRepository{

    void getListRutasAsignadsas();
    void getListRutasBloquedas();
    void getInfoUser();
    void getVersionApp();

    void getUltimoInicio();
    void onClickRuta(QueryRutas ruta);

    void registerHistory();
}
