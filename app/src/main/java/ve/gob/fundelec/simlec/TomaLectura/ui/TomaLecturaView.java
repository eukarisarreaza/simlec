package ve.gob.fundelec.simlec.TomaLectura.ui;

/**
 * Created by fundelec on 10/08/17.
 */

public interface TomaLecturaView {
    void showNotaLectura(String[] data);
    void showInfoRuta(String nom_ruta, String area);
    void showNotify(String message);
}
