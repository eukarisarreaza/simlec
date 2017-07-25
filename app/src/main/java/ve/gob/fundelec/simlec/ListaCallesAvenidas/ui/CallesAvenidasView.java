package ve.gob.fundelec.simlec.ListaCallesAvenidas.ui;

/**
 * Created by fundelec on 25/07/17.
 */

public interface CallesAvenidasView {

    void onBackPress();
    void onButtonMenu();
    void onSearch();

    void showInfoRuta(String nom_ruta, String area);
    void onSelectCalle();
}
