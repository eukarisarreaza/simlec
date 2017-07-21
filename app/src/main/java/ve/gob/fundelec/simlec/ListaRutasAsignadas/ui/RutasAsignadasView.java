package ve.gob.fundelec.simlec.ListaRutasAsignadas.ui;

import java.util.List;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;


/**
 * Created by fundelec on 19/07/17.
 */

public interface RutasAsignadasView {
    void showInfoUser(String nombre, String perfil);
    void showVersionName(String version);
    void showListRutasCurso(List<QueryRutas> list);
}
