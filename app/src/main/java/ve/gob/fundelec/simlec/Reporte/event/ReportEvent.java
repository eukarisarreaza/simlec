package ve.gob.fundelec.simlec.Reporte.event;

import java.util.ArrayList;
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
}
