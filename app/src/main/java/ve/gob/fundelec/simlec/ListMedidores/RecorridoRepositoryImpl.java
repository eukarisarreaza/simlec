package ve.gob.fundelec.simlec.ListMedidores;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Date;
import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Precinto;
import ve.gob.fundelec.simlec.DataBase.entities.Precinto_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListMedidores.entities.QueryMedidores;
import ve.gob.fundelec.simlec.ListMedidores.event.LecturasEvent;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 01/08/17.
 */

public class RecorridoRepositoryImpl implements RecorridoRepository {
    private static final String TAG= RecorridoRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    private List<QueryMedidores> listMedidores;
    private List<QueryObjetoConexion> list_objetos;


    public RecorridoRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
        setListObjetos();
    }

    private void setListObjetos() {
        list_objetos= new Select(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build()).as("id_objeto_conexion"),
                ObjetoConexion_Table.cod_obj_conex, ObjetoConexion_Table.nom_obj_conex, ObjetoConexion_Table.ord_obj_conex,
                ObjetoConexion_Table.emplazamiento,
                Method.count(Medidores_Table.id.withTable(NameAlias.builder("B").build())).as("numMedidores"),
                Method.sum(IndicadoresLectura_Table.status_lectura).as("cant_lect_ejecutadas"))

                .from(ObjetoConexion.class).as("A")

                .innerJoin(Medidores.class).as("B")
                .on(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build())
                        .eq(Medidores_Table.id_objeto_conexion.withTable(NameAlias.builder("B").build())))

                .innerJoin(IndicadoresLectura.class).as("C")
                .on(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("C").build())
                        .eq(Medidores_Table.id.withTable(NameAlias.builder("B").build())))

                .where(ObjetoConexion_Table.id_calle_avenida.is(sessionManager.getCalle().getId_calle()))
                .groupBy(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build()))
                .orderBy(ObjetoConexion_Table.ord_obj_conex, true)
                .queryCustomList(QueryObjetoConexion.class);
    }

    @Override
    public void registerHistory() {
        sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LECTURA_GESTIONAR);
    }

    @Override
    public void getValorDeLectura() {

        LecturasEvent event = new LecturasEvent();
        event.setEventType(LecturasEvent.showUnidadLecturaGestionar);
        event.setPosicionObj(getPosicionObjeto() + "/" + list_objetos.size());
        eventBus.post(event);
    }

    @Override
    public void getMedidorInicio() {
        actualizaListaMedidores();

        if(listMedidores!=null){
            sessionManager.setMedidor(listMedidores.get(0));

            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.valorLectura);
            event.setPosicionMedidor(getPosicionMedidor()+"/"+listMedidores.size());
            eventBus.post(event);
        }
    }

    private void actualizaListaMedidores() {
        listMedidores=null;

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
    }


        /**
         //OBTENGO LA LISTA DE MEDIDORES
        if( sessionManager.getObjetConexion().getCant_lect_ejecutadas()==0){
            // MOSTRAR UNIDAD DE LECTURA A GESTIONAR
            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.showUnidadLecturaGestionar);
            eventBus.post(event);

        }else {
            // ALMACENAR EN PREFERENCIAS EL MEDIDOR A TOMAR LECTURA
            QueryMedidores current=buscarMedidorProxLeer();
            sessionManager.setMedidor(current);

            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.valorLectura);
            eventBus.post(event);
        }
        */

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
            if(medidor.getStatus_lectura()==0 || medidor.getConsumo_kwh()==0d || medidor.getDemanda_va()==0d){
                Log.e(TAG, "PROXIMO MEDIDOR "+medidor.getId_medidor());
                return medidor;
            }
        }

        return listMedidores.get(listMedidores.size()-1);
    }



    @Override
    public void getProximoMedidor() {

        QueryMedidores currentMedidor= sessionManager.getMedidor();

        for (int i=0; i<listMedidores.size(); i++){
            if(currentMedidor.equals(listMedidores.get(i))){
                if(i==list_objetos.size()-1){
                    return;
                }

                sessionManager.setMedidor(listMedidores.get(i+1));
                Log.e(TAG, "proximo medidor a leer "+listMedidores.get(i+1).getId_medidor());

                LecturasEvent event= new LecturasEvent();
                event.setEventType(LecturasEvent.valorLectura);
                event.setPosicionMedidor(getPosicionMedidor()+"/"+listMedidores.size());
                eventBus.post(event);
                return;
            }
        }
    }

    @Override
    public void getPrevioMedidor() {
        QueryMedidores currentMedidor = sessionManager.getMedidor();

        for (int i = 0; i < listMedidores.size(); i++) {
            if (currentMedidor.equals(listMedidores.get(i))) {
                if (i == 0) {
                    return;
                }
                sessionManager.setMedidor(listMedidores.get(i-1));

                LecturasEvent event = new LecturasEvent();
                event.setEventType(LecturasEvent.valorLectura);
                event.setPosicionMedidor(getPosicionMedidor() + "/" + listMedidores.size());
                eventBus.post(event);
                return;
            }
        }
    }

    @Override
    public void getProximoObjetoConexion() {
        sessionManager.setMedidor(null);
        /** NECESITAMOS LA LISTA DE OBJETOS DE COPNEXION  */
        QueryObjetoConexion currentObjetoConexion= sessionManager.getObjetConexion();

        for (int i=0; i<list_objetos.size(); i++){
            if(currentObjetoConexion.equals(list_objetos.get(i))){
                if(i==list_objetos.size()-1){
                    return;
                }
                sessionManager.setObjetoConexion(list_objetos.get(i+1));
                getValorDeLectura();
                return;
            }
        }
    }

    @Override
    public void getPrevioObjetoConexion() {
        sessionManager.setMedidor(null);
        /** NECESITAMOS LA LISTA DE OBJETOS DE COPNEXION  */
        QueryObjetoConexion currentObjetoConexion= sessionManager.getObjetConexion();

        for (int i=0; i<list_objetos.size(); i++){
            if(currentObjetoConexion.equals(list_objetos.get(i))){
                if(i==0){
                    return;
                }
                sessionManager.setObjetoConexion(list_objetos.get(i-1));
                getValorDeLectura();
                return;
            }
        }
    }


    @Override
    public void actualizarPresinto(String retirado, String actual) {
        Log.e(TAG, "ATUALIZAR PRESINTO "+retirado+" "+actual);
        QueryMedidores medidores= sessionManager.getMedidor();
        Log.e(TAG, "Medidor Actual "+medidores.toString());

        Precinto precinto= new Select(Precinto_Table.ALL_COLUMN_PROPERTIES)
                .from(Precinto.class)
                .where(Precinto_Table.id_medidores.is(medidores.getId_medidor()))
                .querySingle();
        if(precinto!=null){
            Log.e(TAG, "precinto "+precinto.toString());
            precinto.setFch_cambio(new Date());
            precinto.setPre_medidor_actual(retirado);
            precinto.setPre_medidor_nuevo(actual);
            precinto.save();
        }else {
            Precinto precinto1= new Precinto();
            precinto1.setId((int)Math.random()*215454445+1);
            precinto1.setId_medidores(medidores.getId_medidor());
            precinto1.setFch_cambio(new Date());
            precinto1.setPre_medidor_nuevo(actual);
            precinto1.setPre_medidor_actual(retirado);
            precinto1.setVersion(1);
            precinto1.setAccion(1);
            precinto1.save();
            Log.e(TAG, "precinto creado "+precinto1.toString());
        }
    }

    @Override
    public void saveLectura() {

        /**VERIFICAR SI ESTA ACTIVA UNIDAD DE LECTURA A GECTIONAR O VALOR DE LECTURA */

        TomaLecturaEvent event=new TomaLecturaEvent();
        event.setEventType(TomaLecturaEvent.saveLectura);
        eventBus.post(event);
    }

    @Override
    public void selecLetterP() {

        QueryMedidores medidores= sessionManager.getMedidor();
        Log.e(TAG, "Medidor Actual "+medidores.toString());

        Precinto precinto= new Select(Precinto_Table.ALL_COLUMN_PROPERTIES)
                .from(Precinto.class)
                .where(Precinto_Table.id_medidores.is(medidores.getId_medidor()))
                .querySingle();

        if(precinto==null) {
            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.actualizarPresinto);
            event.setRetirado("123456");
            eventBus.post(event);
        }else {
            LecturasEvent event= new LecturasEvent();
            event.setEventType(LecturasEvent.actualizarPresinto);
            event.setRetirado(precinto.getPre_medidor_actual());
            eventBus.post(event);
        }


    }


    public int getPosicionObjeto() {
        QueryObjetoConexion currentObjetoConexion= sessionManager.getObjetConexion();

        for (int i=0; i<list_objetos.size(); i++){
            if(currentObjetoConexion.equals(list_objetos.get(i))){
              return i+1;
            }
        }
        return 0;
    }

    public int getPosicionMedidor() {
        QueryMedidores currentMedidor= sessionManager.getMedidor();

        for (int i=0; i<listMedidores.size(); i++){
            if(currentMedidor.equals(listMedidores.get(i))){
                return i+1;
            }
        }
        return 0;
    }
}
