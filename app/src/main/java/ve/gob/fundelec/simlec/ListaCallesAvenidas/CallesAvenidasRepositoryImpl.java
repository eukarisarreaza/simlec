package ve.gob.fundelec.simlec.ListaCallesAvenidas;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida;
import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.event.CallesAvenidasEvent;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
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
    public void getInfoRuta() {
        ruta= sessionManager.getRuta();
        postEvent(CallesAvenidasEvent.showInfoRuta, ruta);
    }

    @Override
    public void getListCalles() {

        /**
         CREATE OR REPLACE VIEW vw_calle_avenida_apk_01 AS
         SELECT b.id AS id_calle,
         b.nom_calle,
         a.id_lector,
         a.id_dispositivo_movil,
         sum(a.cant_lect_programadas) AS cant_lect_programadas,
         sum(a.cant_lect_gestionada) AS "cant_lect_gestionadasŗ",
         (sum(a.cant_lect_gestionada) / sum(a.cant_lect_programadas) * 100::numeric)::integer AS porcentaje_avance
         FROM programacion_calle a
         JOIN calle_avenida b ON a.id_calle_avenida = b.id
         GROUP BY b.id, b.nom_calle, a.id_lector, a.id_dispositivo_movil;
         */


        List<QueryCalles> list= new Select(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build()).as("id_calle"),
                CalleAvenida_Table.nom_calle, ProgramacionCalle_Table.id_lector, ProgramacionCalle_Table.id_dispositivo_movil,
                Method.sum(ProgramacionCalle_Table.cant_lect_programadas).as("cant_lect_programadas"),
                Method.sum(ProgramacionCalle_Table.cant_lect_gestionada).as("cant_lect_gestionadasŗ"))
                .from(ProgramacionCalle.class).as("A")
                .innerJoin(CalleAvenida.class).as("B")
                .on(ProgramacionCalle_Table.id_calle_avenida.withTable(NameAlias.builder("A").build())
                        .eq(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build())))
                .groupBy(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build()))
                .queryCustomList(QueryCalles.class);


        Log.e(TAG, "size de calles "+list.size());
        for (QueryCalles calle: list) {
            Log.e(TAG, "item "+calle.getNom_calle());
            Log.e(TAG, "gestionadas "+calle.getCant_lect_gestionadasŗ());
            Log.e(TAG, "programadas "+calle.getCant_lect_progr());
        }

        postEvent(CallesAvenidasEvent.showListCalles, list);

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
