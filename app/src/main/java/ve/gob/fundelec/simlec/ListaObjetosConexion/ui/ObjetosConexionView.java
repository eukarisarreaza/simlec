package ve.gob.fundelec.simlec.ListaObjetosConexion.ui;

import java.util.List;

import ve.gob.fundelec.simlec.ListaObjetosConexion.entities.QueryObjetoConexion;

/**
 * Created by fundelec on 26/07/17.
 */

public interface ObjetosConexionView {

    void showListObjetosConexion(List<QueryObjetoConexion> list);
    void showInfoRuta(String ruta, String area);
    void showInfoCalle(String nom_calle, String avance);


    void search();
    void menu();
    void back();

}
