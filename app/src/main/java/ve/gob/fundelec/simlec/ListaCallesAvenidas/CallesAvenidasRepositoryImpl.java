package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida;
import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Estados;
import ve.gob.fundelec.simlec.DataBase.entities.Estados_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Municipios;
import ve.gob.fundelec.simlec.DataBase.entities.Municipios_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Parroquias;
import ve.gob.fundelec.simlec.DataBase.entities.Parroquias_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.event.CallesAvenidasEvent;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.Main.event.RecorridoEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 25/07/17.
 */

public class CallesAvenidasRepositoryImpl implements CallesAvenidasRepository{
    private LectorSessionManager sessionManager;
    private EventBus eventBus;
    private QueryRutas ruta;
    private static final String TAG= CallesAvenidasRepositoryImpl.class.getName();


    public CallesAvenidasRepositoryImpl(LectorSessionManager sessionManager, EventBus eventBus) {
        this.sessionManager = sessionManager;
        this.eventBus = eventBus;
    }

    @Override
    public void registerHistory() {
        sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LISTA_CALLES_AVENIDAS);
    }

    @Override
    public void getInfoRuta() {
        ruta= sessionManager.getRuta();
        postEvent(CallesAvenidasEvent.showInfoRuta, ruta);
    }

    @Override
    public void getListCalles() {

        List<QueryCalles> list= new Select(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build()).as("id_calle"),
                CalleAvenida_Table.nom_calle, ProgramacionCalle_Table.id_lector, ProgramacionCalle_Table.id_dispositivo_movil,
                ProgramacionCalle_Table.id.withTable(NameAlias.builder("A").build()).as("id_programacion_calle"),
                Parroquias_Table.parroquia, Municipios_Table.municipio, Estados_Table.estado,
                Method.sum(ProgramacionCalle_Table.cant_lect_programadas).as("cant_lect_programadas"),
                Method.sum(ProgramacionCalle_Table.cant_lect_gestionada).as("cant_lect_gestionadasŗ"))
                .from(ProgramacionCalle.class).as("A")
                .innerJoin(CalleAvenida.class).as("B")
                .on(ProgramacionCalle_Table.id_calle_avenida.withTable(NameAlias.builder("A").build())
                        .eq(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build())))

                .innerJoin(Parroquias.class).as("C")
                .on(CalleAvenida_Table.id_parroquia.withTable(NameAlias.builder("B").build())
                        .eq(Parroquias_Table.id_parroquia.withTable(NameAlias.builder("C").build())))

                .innerJoin(Municipios.class).as("D")
                .on(Parroquias_Table.id_municipio.withTable(NameAlias.builder("C").build())
                        .eq(Municipios_Table.id_municipio.withTable(NameAlias.builder("D").build())))

                .innerJoin(Estados.class).as("E")
                .on(Municipios_Table.id_estado.withTable(NameAlias.builder("D").build())
                        .eq(Estados_Table.id_estado.withTable(NameAlias.builder("E").build())))

                .where(CalleAvenida_Table.id_ruta.is(sessionManager.getRuta().getId_ruta())) /** TODO STUB */

                .groupBy(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build()))
                .queryCustomList(QueryCalles.class);


        Log.e(TAG, "size de calles "+list.size());
        for (QueryCalles calle: list) {
            Log.e(TAG, "item "+calle.getNom_calle());
            Log.e(TAG, "gestionadas "+calle.getCant_lect_gestionadasŗ());
            Log.e(TAG, "programadas "+calle.getCant_lect_programadas());
        }

        postEvent(CallesAvenidasEvent.showListCalles, list);

    }

    @Override
    public void onClickCalle(QueryCalles item) {
        sessionManager.setCalle(item);
        RecorridoEvent event= new RecorridoEvent();
        event.setEventType(RecorridoEvent.onClickCalleAv);
        eventBus.post(event);
    }


    private void postEvent(int type, QueryRutas ruta){
        CallesAvenidasEvent event= new CallesAvenidasEvent();
        event.setEventType(type);
        event.setRuta(ruta);
        eventBus.post(event);
    }

    private void postEvent(int type, List<QueryCalles> listCallesAv){
        CallesAvenidasEvent event= new CallesAvenidasEvent();
        event.setEventType(type);
        event.setListCallesAv(listCallesAv);
        eventBus.post(event);
    }

}
