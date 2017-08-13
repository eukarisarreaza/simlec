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
            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.showUnidadLecturaGestionar);
            eventBus.post(event);

        }else {
            /** ALMACENAR EN PREFERENCIAS EL MEDIDOR A TOMAR LECTURA*/
            QueryMedidores current=buscarMedidorProxLeer();
            sessionManager.setMedidor(current);

            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.valorLectura);
            eventBus.post(event);
        }

    }

    private QueryMedidores buscarMedidorProxLeer(){
        listMedidores= new Select(Medidores_Table.id.withTable(NameAlias.builder("A").build()).as("id_medidor"), Medidores_Table.long_lat,
                Medidores_Table.dig_entero, Medidores_Table.dig_decimal, Medidores_Table.modelo, Medidores_Table.numero,
                Medidores_Table.ubicacion, IndicadoresLectura_Table.id.withTable(NameAlias.builder("C").build()).as("id_indicador_lectura"),
                IndicadoresLectura_Table.id_programacion_calle, IndicadoresLectura_Table.orden_lectura, IndicadoresLectura_Table.cod_nota_lectura,
                IndicadoresLectura_Table.status_lectura, IndicadoresLectura_Table.lim_super_kwh, IndicadoresLectura_Table.lim_infer_kwh,
                IndicadoresLectura_Table.lim_infer_va, IndicadoresLectura_Table.lim_infer_va, IndicadoresLectura_Table.lectura_prevista,
                IndicadoresLectura_Table.fch_toma_lectura, IndicadoresLectura_Table.consumo_kwh, IndicadoresLectura_Table.demanda_va)
                .from(Medidores.class).as("A")

                .innerJoin(IndicadoresLectura.class).as("C")
                .on(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("C").build())
                        .eq(Medidores_Table.id.withTable(NameAlias.builder("A").build())))

                .where(Medidores_Table.id_objeto_conexion.is(sessionManager.getObjetConexion().getId_objeto_conexion()))
                .queryCustomList(QueryMedidores.class);


        for (QueryMedidores medidor: listMedidores) {
            if(medidor.getStatus_lectura()==0){
                Log.e(TAG, "PROXIMO MEDIDOR "+medidor.getId_medidor());
                return medidor;
            }
        }
        return null;
    }

    private QueryMedidores buscarMedidorPrevLeer(){

        return null;
    }

    @Override
    public void getNombreObjetoConexionSeleccionado() {
        Log.e(TAG, "OBEJETO "+sessionManager.getObjetConexion().getId_objeto_conexion());
        postEventNomMedidor(LecturasEvent.showNombreObjetoConexion, sessionManager.getObjetConexion().getNom_obj_conex());
    }


    @Override
    public void getProximoMedidor() {
        QueryMedidores current=buscarMedidorProxLeer();
        Log.e(TAG, "proximo medidor a leer "+current.getId_medidor());
        sessionManager.setMedidor(current);

        LecturasEvent event= new LecturasEvent();
        event.setEventType(LecturasEvent.valorLectura);
        eventBus.post(event);
    }

    @Override
    public void getPrevioMedidor() {
        QueryMedidores current=buscarMedidorPrevLeer();
        sessionManager.setMedidor(current);

        LecturasEvent event= new LecturasEvent();
        event.setEventType(LecturasEvent.valorLectura);
        eventBus.post(event);

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

}
