package ve.gob.fundelec.simlec.Campaña.ui;

import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.Medidores;

/**
 * Created by fundelec on 14/07/17.
 */

public interface CampanaView {

    void onBackPress();
    void onButtonMenu();
    void showListMedidores(List<Medidores> list);
}
