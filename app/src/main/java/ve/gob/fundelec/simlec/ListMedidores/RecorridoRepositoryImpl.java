package ve.gob.fundelec.simlec.ListMedidores;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListMedidores.entities.QueryMedidores;
import ve.gob.fundelec.simlec.ListMedidores.event.LecturasEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 *
 /**

 .where(Medidores_Table.id_objeto_conexion.is(objetoConexion.getId_objeto_conexion()))
 for (QueryObjetoConexion objetoConexion : list) {

 Log.e(TAG, objetoConexion.getNom_obj_conex());

 List<QueryMedidores> medidoresList= new Select()
 .from(Medidores.class).as("A")
 .innerJoin(IndicadoresLectura.class).as("B")
 .on(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("B").build())
 .eq(Medidores_Table.id.withTable(NameAlias.builder("A").build())))
 .where(Medidores_Table.id_objeto_conexion.is(objetoConexion.getId_objeto_conexion()))
 .queryCustomList(QueryMedidores.class);
 }



 .innerJoin(Medidores.class).as("B")
 .on(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build())
 .eq(Medidores_Table.id_objeto_conexion.withTable(NameAlias.builder("B").build())))

 .innerJoin(IndicadoresLectura.class).as("C")
 .on(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("C").build())
 .eq(Medidores_Table.id.withTable(NameAlias.builder("B").build())))


 * Created by fundelec on 01/08/17.
 */

public class RecorridoRepositoryImpl implements RecorridoRepository {
    private static final String TAG= RecorridoRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    private List<QueryMedidores> listMedidores;


    public RecorridoRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }

    @Override
    public void registerHistory() {
        sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LECTURA_GESTIONAR);
    }

    @Override
    public void getMedidorInicio() {
        /** OBTENGO LA LISTA DE MEDIDORES */
        if( sessionManager.getObjetConexion().getCant_lect_ejecutadas()==0){
            /** MOSTRAR UNIDAD DE LECTURA A GESTIONAR */
            postEvent(LecturasEvent.showUnidadLecturaGestionar);

        }else {
            /** ALMACENAR EN PREFERENCIAS EL MEDIDOR A TOMAR LECTURA*/
            QueryMedidores current=buscarMedidorProxLeer();
            sessionManager.setMedidor(current);

            postEvent(LecturasEvent.showUnidadLecturaGestionar);
        }

    }

    private QueryMedidores buscarMedidorProxLeer(){
        listMedidores= new Select()
                .from(Medidores.class).as("A")

                .innerJoin(IndicadoresLectura.class).as("C")
                .on(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("C").build())
                        .eq(Medidores_Table.id.withTable(NameAlias.builder("A").build())))

                .where(Medidores_Table.id_objeto_conexion.is(sessionManager.getObjetConexion().getId_objeto_conexion()))
                .queryCustomList(QueryMedidores.class);

        for (QueryMedidores medidor: listMedidores) {
            if(medidor.getStatus_lectura()==0)
                return medidor;
        }
        return null;
    }

    private QueryMedidores buscarMedidorPrevLeer(){
        listMedidores= new Select()
                .from(Medidores.class).as("A")

                .innerJoin(IndicadoresLectura.class).as("C")
                .on(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("C").build())
                        .eq(Medidores_Table.id.withTable(NameAlias.builder("A").build())))

                .where(Medidores_Table.id_objeto_conexion.is(sessionManager.getObjetConexion().getId_objeto_conexion()))
                .queryCustomList(QueryMedidores.class);

        for (QueryMedidores medidor: listMedidores) {
            if(medidor.getStatus_lectura()==0)
                return medidor;
        }
        return null;
    }

    @Override
    public void getNombreObjetoConexionSeleccionado() {
        Log.e(TAG, "OBEJETO "+sessionManager.getObjetConexion().getNom_obj_conex());
        postEventNomMedidor(LecturasEvent.showNombreObjetoConexion, sessionManager.getObjetConexion().getNom_obj_conex());
    }


    @Override
    public void getProximoMedidor() {
        QueryMedidores current=buscarMedidorProxLeer();
        sessionManager.setMedidor(current);

        postEvent(LecturasEvent.showUnidadLecturaGestionar);
    }

    @Override
    public void getPrevioMedidor() {
        QueryMedidores current=buscarMedidorPrevLeer();
        sessionManager.setMedidor(current);

        postEvent(LecturasEvent.showUnidadLecturaGestionar);
    }

    @Override
    public void añadirSobrante() {

    }

    @Override
    public void actualizarPresinto() {

    }

    private void postEventNomMedidor(int eventType, String message) {
        LecturasEvent event= new LecturasEvent();
        event.setEventType(eventType);
        event.setNom_medidor(message);
        eventBus.post(event);
    }

    private void postEvent(int eventType) {
        LecturasEvent event= new LecturasEvent();
        event.setEventType(eventType);
        eventBus.post(event);
    }
}
