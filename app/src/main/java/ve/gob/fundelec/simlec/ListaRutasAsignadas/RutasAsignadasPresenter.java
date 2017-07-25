package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.event.RutasAsignadasEvent;

/**
 * Created by fundelec on 19/07/17.
 */

public interface RutasAsignadasPresenter {
    void onCreate();
    void onDestroy();

    void onEventMainThread(RutasAsignadasEvent event);

    void getListRutas();
    void getInfoUser();
    void getVersionApp();
    void getUltimoInicio();

    void onClickRuta(QueryRutas ruta);
}
