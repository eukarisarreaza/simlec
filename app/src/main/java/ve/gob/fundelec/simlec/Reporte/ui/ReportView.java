package ve.gob.fundelec.simlec.Reporte.ui;

import java.util.HashMap;
import java.util.List;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 28/08/17.
 */

public interface ReportView {

    void onBackPress();
    void onButtonMenu();
    void showListRutas(List<String> header, HashMap<String, List<QueryCalles>> listDataChild);
    void showError(String message);
    void showReport(float[] yData);
    void showDetailsReport(int total_ord_lect, int total_ord_leidas, int ordenes_faltantes, float procentaje_realiz,
                           float porcentaje_x_leer, int total_obj_conexion, int objetos_conexion_pendiente);

}
