package ve.gob.fundelec.simlec.Recorrido.ui;

/**
 * Created by fundelec on 01/08/17.
 */

public interface RecorridoView {


    void showNombreObjConexion(String nombre);
    void next();
    void prev();

    void sigFragment();
    void prevFragment();

    void search();
    void menu();
    void letter_p();
    void letter_s();
}
