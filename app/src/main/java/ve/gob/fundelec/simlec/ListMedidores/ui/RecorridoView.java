package ve.gob.fundelec.simlec.ListMedidores.ui;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoView {
    void showNombreObjConexion(String nombre);
    void lecturaGestionar();
    void valorLectura();
    void showNotify(String message);

    void nextMedidor();
    void prevMedidor();

    void sigObjetoConexion();
    void prevObjetoConexion();

    void search();
    void menu();
    void letter_p();
    void letter_s();
    void back();
}
