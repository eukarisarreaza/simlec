package ve.gob.fundelec.simlec.Reporte;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida;
import ve.gob.fundelec.simlec.DataBase.entities.CalleAvenida_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Estados;
import ve.gob.fundelec.simlec.DataBase.entities.Estados_Table;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Municipios;
import ve.gob.fundelec.simlec.DataBase.entities.Municipios_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Parroquias;
import ve.gob.fundelec.simlec.DataBase.entities.Parroquias_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta;
import ve.gob.fundelec.simlec.DataBase.entities.Ruta_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.Reporte.event.ReportEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportRepositoryImpl implements ReportRepository {
    private static final String TAG= ReportRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;


    public ReportRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }


    @Override
    public void getListRutas() {
        List<String> header= new ArrayList<>();
        HashMap<String, List<QueryCalles>> listDataChild = new HashMap<>();

        if(sessionManager.getUser().getRol_operador()==1) {// si es lector

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

            for (QueryRutas ruta: list) {
                header.add(ruta.getCod_ruta());

                List<QueryCalles> list_calles= new Select(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build()).as("id_calle"),
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

                listDataChild.put(ruta.getCod_ruta(), list_calles); // Header, Child data

            }


            ReportEvent event= new ReportEvent();
            event.setHeader(header);
            event.setListDataChild(listDataChild);
            event.setEventType(ReportEvent.showListRutas);
            eventBus.post(event);
        }



    }

    @Override
    public void getReport(QueryCalles calle) {
        float[] yData= new float[2];
        yData[0]=(calle.getCant_lect_gestionadasŗ()*100)/calle.getCant_lect_programadas(); //leidas
        yData[1]=((calle.getCant_lect_programadas()-calle.getCant_lect_gestionadasŗ())*100)/calle.getCant_lect_programadas(); //no leidas

        ReportEvent event= new ReportEvent();
        event.setyData(yData);
        event.setEventType(ReportEvent.showReport);

        /** TOTAL DE ORDENES DE LECTURA **/
        event.setTotal_ord_lect(calle.getCant_lect_programadas());
        /** TOTAL DE ORDENES LEIDAS **/
        event.setTotal_ord_leidas(calle.getCant_lect_gestionadasŗ());
        /** TOTAL DE ORDENES FALTANTES **/
        event.setOrdenes_faltantes(calle.getCant_lect_programadas()-calle.getCant_lect_gestionadasŗ());
        /** PORCENTAJE RELIZADO **/
        event.setProcentaje_realiz(yData[0]);
        /** PORCENTAJE POR LEER **/
        event.setProcentaje_realiz(yData[1]);
        /** TOTAL OBJETOS DE CONEXION **/
        List<QueryObjetoConexion> list= new Select(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build()).as("id_objeto_conexion"),
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

                .where(ObjetoConexion_Table.id_calle_avenida.is(calle.getId_calle()))
                .groupBy(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build()))
                .orderBy(ObjetoConexion_Table.ord_obj_conex, true)
                .queryCustomList(QueryObjetoConexion.class);
        event.setTotal_obj_conexion(list.size());

        /** TOTAL OBJETOS DE CONEXION PENDIENTE **/
        event.setTotal_obj_conexion(list.size()-list.get(0).getCant_lect_ejecutadas());


        eventBus.post(event);
    }



}
