package ve.gob.fundelec.simlec.Main.ui;

import java.util.List;

import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;

/**
 * Created by fundelec on 10/07/17.
 */

public interface MainView {
    void showListOpciones(List<ItemMenu> list);

    void rutasAsinadas();
    void aparatoSobrante();
    void campaña();
    void reporte();
    void sincronizar();
    void salir();
    void bateria();
    void linterna();
}
