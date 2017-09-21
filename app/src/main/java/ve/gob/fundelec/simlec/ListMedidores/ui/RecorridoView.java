package ve.gob.fundelec.simlec.ListMedidores.ui;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoView {
    void lecturaGestionar(String pos);
    void valorLectura(String pos);
    void showNotify(String message);

    void ocultarBotonesSiguienteObjConexion();
    void ocultarBotonesSiguinteMedidor();

    void mostrarBotonesSiguienteObjConexion();
    void mostrarBotonesSiguinteMedidor();

    void nextMedidor();
    void prevMedidor();
    void saveLectrura();
    void sigObjetoConexion();
    void prevObjetoConexion();
    void dialogoActualizarPresinto(String retirado);

    void search();
    void menu();
    void letter_p();
    void letter_s();
    void back();
}
