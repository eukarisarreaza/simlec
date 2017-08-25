package ve.gob.fundelec.simlec.ListMedidores;

import ve.gob.fundelec.simlec.ListMedidores.event.LecturasEvent;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoPressenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LecturasEvent event);
    void getFragmentInicio();
    void registrarFragment();

    void proximoMedidor();
    void anteriorMedidor();

    void proximoObjetoConexion();
    void anteriorObjetoConexion();
    void actualizarPresinto(String retirado, String actual);
    void saveLecrura();

    void selectLetterP();
}
