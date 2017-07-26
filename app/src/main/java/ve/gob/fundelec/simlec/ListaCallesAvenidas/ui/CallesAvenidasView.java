package ve.gob.fundelec.simlec.ListaCallesAvenidas.ui;

import java.util.List;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 25/07/17.
 */

public interface CallesAvenidasView {

    void onBackPress();
    void onButtonMenu();
    void onSearch();

    void showInfoRuta(String nom_ruta, String area);
    void showListCalles(List<QueryCalles> callesList);
    void onSelectCalle(QueryCalles calle);
}
