package ve.gob.fundelec.simlec.LecturaGestionar.ui;

/**
 * Created by fundelec on 10/08/17.
 */

public interface LecturaGestionarView {
    void showListNotas(String[] data);
    void showNotify(String message);
    void showInfoRuta(String nom_ruta, String area);
    void showUnidadLectura(String unidad_lectura);
    void showObjetivoConexion(String objConexion);
    void showDireccion(String municipio, String parroquia, String urbanizacion, String calle);
}
