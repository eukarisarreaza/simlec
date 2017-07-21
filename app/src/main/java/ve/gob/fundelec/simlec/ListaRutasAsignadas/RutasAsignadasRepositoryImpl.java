package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida;
import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Lector;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.event.RutasAsignadasEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasRepositoryImpl implements RutasAsignadasRepository{
    private static final String TAG= RutasAsignadasRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;

    public RutasAsignadasRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }

    @Override
    public void getListRutasAsignadsas() {

        /***
        SELECT c.id,
        c.nom_ruta,
        'C.C.C.T 0001 '::text AS area,
        a.id_lector,
        a.id_dispositivo_movil,
        sum(a.cant_lect_programadas) AS cant_lect_programadas,
        sum(a.cant_lect_gestionada) AS "cant_lect_gestionadasŗ",
        (sum(a.cant_lect_gestionada) / sum(a.cant_lect_programadas) * 100::numeric)::integer AS porcentaje_avance
       FROM programacion_calle a
         JOIN calle_avenida b ON a.id_calle_avenida = b.id
         JOIN ruta c ON b.id_ruta = c.id
       GROUP BY c.id, c.nom_ruta, 'C.C.C.T 0001 '::text, a.id_lector, a.id_dispositivo_movil;

         */

        /** ASUMIMOS QUE TODOS LAS TUPLAS QUE AQUI ESTEN SON PARA ESTE DISPOSITIVO MOVIL **/
        List<QueryRutas> list= new Select(ProgramacionCalle_Table.id.withTable(NameAlias.builder("C").build()).as("id_programacion_calle"),
                CalleAvenida_Table.id.withTable(NameAlias.builder("R").build()).as("id_calle_avenida"),
                ProgramacionCalle_Table.fch_programa, ProgramacionCalle_Table.id_lector, ProgramacionCalle_Table.id_dispositivo_movil,
                ProgramacionCalle_Table.fch_asig_diaria, CalleAvenida_Table.id_ruta, CalleAvenida_Table.id_parroquia,
                CalleAvenida_Table.cod_calle, CalleAvenida_Table.nom_calle, CalleAvenida_Table.secuencia, CalleAvenida_Table.sector,
                Ruta_Table.cod_ruta, Ruta_Table.nom_ruta)
                .from(ProgramacionCalle.class).as("C")
                .innerJoin(CalleAvenida.class).as("R")
                .on(ProgramacionCalle_Table.id_calle_avenida.withTable(NameAlias.builder("C").build())
                        .eq(CalleAvenida_Table.id.withTable(NameAlias.builder("R").build())))
                .innerJoin(Ruta.class).as("D")
                .on(CalleAvenida_Table.id_ruta.withTable(NameAlias.builder("R").build())
                        .eq(Ruta_Table.id.withTable(NameAlias.builder("D").build())))
                .groupBy(CalleAvenida_Table.id_ruta, Ruta_Table.nom_ruta, ProgramacionCalle_Table.id_lector, ProgramacionCalle_Table.id_dispositivo_movil)
                .queryCustomList(QueryRutas.class);

        Log.e(TAG, "size "+list.size());

        postEvent(RutasAsignadasEvent.showListRutasEnCurso, list);

    }

    @Override
    public void getListRutasBloquedas() {

    }

    @Override
    public void getUltimoInicio() {

    }

    @Override
    public void getInfoUser() {
        postEvent(RutasAsignadasEvent.showInfoUser, sessionManager.getUser());
    }

    @Override
    public void getVersionApp() {
        postEvent(RutasAsignadasEvent.showVersionApp, "v. 1.0.2");
    }



    private void postEvent(int type, List<QueryRutas> listRutas){
        RutasAsignadasEvent event= new RutasAsignadasEvent();
        event.setEventType(type);
        event.setListRutas(listRutas);
        eventBus.post(event);
    }

    private void postEvent(int type, Lector lector){
        RutasAsignadasEvent event= new RutasAsignadasEvent();
        event.setEventType(type);
        event.setLector(lector);
        eventBus.post(event);
    }

    private void postEvent(int type, String version){
        RutasAsignadasEvent event= new RutasAsignadasEvent();
        event.setEventType(type);
        event.setVersionApp(version);
        eventBus.post(event);
    }
}
