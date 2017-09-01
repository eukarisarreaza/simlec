package ve.gob.fundelec.simlec.Reporte.event;

import java.util.HashMap;
import java.util.List;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportEvent {
    public static final int showListRutas=1;
    public static final int showReport=2;
    public static final int onError=3;

    private int eventType;
    private String message;

    private List<String> header;
    private HashMap<String, List<QueryCalles>> listDataChild;
    private float[] yData;
    int total_ord_lect;
    int total_ord_leidas;
    int ordenes_faltantes;
    float procentaje_realiz;
    float porcentaje_x_leer;
    int total_obj_conexion;
    int objetos_conexion_pendiente;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public HashMap<String, List<QueryCalles>> getListDataChild() {
        return listDataChild;
    }

    public void setListDataChild(HashMap<String, List<QueryCalles>> listDataChild) {
        this.listDataChild = listDataChild;
    }


    public float[] getyData() {
        return yData;
    }

    public void setyData(float[] yData) {
        this.yData = yData;
    }

    public int getTotal_ord_lect() {
        return total_ord_lect;
    }

    public void setTotal_ord_lect(int total_ord_lect) {
        this.total_ord_lect = total_ord_lect;
    }

    public int getTotal_ord_leidas() {
        return total_ord_leidas;
    }

    public void setTotal_ord_leidas(int total_ord_leidas) {
        this.total_ord_leidas = total_ord_leidas;
    }

    public int getOrdenes_faltantes() {
        return ordenes_faltantes;
    }

    public void setOrdenes_faltantes(int ordenes_faltantes) {
        this.ordenes_faltantes = ordenes_faltantes;
    }

    public float getProcentaje_realiz() {
        return procentaje_realiz;
    }

    public void setProcentaje_realiz(float procentaje_realiz) {
        this.procentaje_realiz = procentaje_realiz;
    }

    public float getPorcentaje_x_leer() {
        return porcentaje_x_leer;
    }

    public void setPorcentaje_x_leer(float porcentaje_x_leer) {
        this.porcentaje_x_leer = porcentaje_x_leer;
    }

    public int getTotal_obj_conexion() {
        return total_obj_conexion;
    }

    public void setTotal_obj_conexion(int total_obj_conexion) {
        this.total_obj_conexion = total_obj_conexion;
    }

    public int getObjetos_conexion_pendiente() {
        return objetos_conexion_pendiente;
    }

    public void setObjetos_conexion_pendiente(int objetos_conexion_pendiente) {
        this.objetos_conexion_pendiente = objetos_conexion_pendiente;
    }
}
