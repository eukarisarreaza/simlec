package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
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
import ve.gob.fundelec.simlec.Main.event.RecorridoEvent;
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
        if(sessionManager.getUser().getRol_operador()==1) {// si es lector

            /** ASUMIMOS QUE TODOS LAS TUPLAS QUE AQUI ESTEN SON PARA ESTE DISPOSITIVO MOVIL **/
            List<QueryRutas> list= new Select(ProgramacionCalle_Table.id.withTable(NameAlias.builder("C").build()).as("id_programacion_calle"),
                    CalleAvenida_Table.id.withTable(NameAlias.builder("R").build()).as("id_calle_avenida"),
                    ProgramacionCalle_Table.fch_programa, ProgramacionCalle_Table.id_lector, ProgramacionCalle_Table.id_dispositivo_movil.withTable(NameAlias.builder("C").build()),
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
                    .groupBy(CalleAvenida_Table.id_ruta, Ruta_Table.nom_ruta, ProgramacionCalle_Table.id_lector, ProgramacionCalle_Table.id_dispositivo_movil.withTable(NameAlias.builder("C").build()))
                    .queryCustomList(QueryRutas.class);

            Log.e(TAG, "size "+list.size());

            postEvent(RutasAsignadasEvent.showListRutasEnCurso, list);

        }

    }

    @Override
    public void getListRutasBloquedas() {



    }

    @Override
    public void getUltimoInicio() {
        /** OBTENER EL ULTIMO INCIO SESION **/
        //postEvent(RutasAsignadasEvent., "v. 1.0.2");
    }

    @Override
    public void onClickRuta(QueryRutas ruta) {
        /** GUARDAR EN PREFERENCIAS LAS RUTAS **/
        sessionManager.setRuta(ruta);
        RecorridoEvent event= new RecorridoEvent();
        event.setEventType(RecorridoEvent.onClickRuta);
        eventBus.post(event);
    }

    @Override
    public void registerHistory() {
        sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LISTA_RUTAS_ASIGNADAS);
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
