package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida;
import ve.gob.fundelec.simlec.DataBase.entities.Lector;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.event.RutasAsignadasEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasRepositoryImpl implements RutasAsignadasRepository{
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

         List<ProgramacionCalle> rutas= SQLite.select()
         .from(ProgramacionCalle.class)
         .innerJoin(CalleAvenida.class)
         .on()

         */

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
