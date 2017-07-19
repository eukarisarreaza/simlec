package ve.gob.fundelec.simlec.ListaRutasAsignadas.event;

import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.Lector;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasEvent {
    public final static int showListRutasEnCurso= 1;
    public final static int showListRutasBloquedas= 2;
    public final static int showInfoUser = 3;
    public final static int showVersionApp = 4;
    private int eventType;
    private String errorMessage;
    private Lector lector;
    private List<Ruta> list;
    private String versionApp;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public List<Ruta> getList() {
        return list;
    }

    public void setList(List<Ruta> list) {
        this.list = list;
    }

    public String getVersionApp() {
        return versionApp;
    }

    public void setVersionApp(String versionApp) {
        this.versionApp = versionApp;
    }
}
