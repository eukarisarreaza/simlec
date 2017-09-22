package ve.gob.fundelec.simlec.TomaLectura.ui;

/**
 * Created by fundelec on 10/08/17.
 */

public interface TomaLecturaView {
    void showNumMedidor(String numMedidor);
    void showLectura1(String text);
    void showLectura2(String text);
    void setNumeroDecimalesEnteros(int decimales, int num_enteros);
    void showNotaLectura(int pos);

    void showInfoRuta(String nom_ruta, String area);
    void showUnidadLecturua(String text);
    void showSumEnergCall1(String text);
    void showPuntoSuministro(String text);
    void showEmplazamiento(String text);
    void showAparato(String text);

    void onSelectObjetoConexion();


    void showNotaLectura(String[] data);
    void showNotify(String message);

    void onSuccesGrabarLectura();
    void onFailedGrabarLectura();
    String getLectura1();
    String getLectura2();


}
