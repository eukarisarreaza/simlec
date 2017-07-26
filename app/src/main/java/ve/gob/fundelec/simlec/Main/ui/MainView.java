package ve.gob.fundelec.simlec.Main.ui;

import java.util.List;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;

/**
 * Created by fundelec on 10/07/17.
 */

public interface MainView {
    void showListOpciones(List<ItemMenu> list);

    void listaRutasAsignadas();
    void listaCallesAvenidas();
    void listaObjetosConexion();
    void lecturaGestionar();

    void aparatoSobrante();
    void campaña();
    void reporte();
    void sincronizar();
    void salir();
    void bateria();
    void linterna();

    void onBackPress();
    void onButtonMenu();
    void onClickPresinto();
    void onClickSobrante();
    void onSearch();

}
