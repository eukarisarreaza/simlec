package ve.gob.fundelec.simlec.ListadoCentrosMedicion;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Main.event.RecorridoEvent;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.entities.QueryObjetoConexion;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.event.ObjetosConexionEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 26/07/17.
 */

public class ObjetosConexionRepositoryImpl implements ObjetosConexionRepository {
    private static final String TAG=ObjetosConexionRepositoryImpl.class.getName();
    private LectorSessionManager sessionManager;
    private EventBus eventBus;

    public ObjetosConexionRepositoryImpl(LectorSessionManager sessionManager, EventBus eventBus) {
        this.sessionManager = sessionManager;
        this.eventBus = eventBus;
    }

    @Override
    public void registerHistory() {
        sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LISTA_CENTROS_MEDICION);
    }

    @Override
    public void getRuta() {
        ObjetosConexionEvent event= new ObjetosConexionEvent();
        event.setRuta(sessionManager.getRuta());
        event.setEventType(ObjetosConexionEvent.showInfoRuta);
        eventBus.post(event);
    }

    @Override
    public void getInfoCalle() {
        ObjetosConexionEvent event= new ObjetosConexionEvent();
        event.setCalles(sessionManager.getCalle());
        event.setEventType(ObjetosConexionEvent.showInfoCalle);
        eventBus.post(event);
    }

    @Override
    public void getListObjetosConexion() {

        List<QueryObjetoConexion> list= new Select(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build()).as("id_objeto_conexion"),
                ObjetoConexion_Table.cod_obj_conex, ObjetoConexion_Table.nom_obj_conex, ObjetoConexion_Table.ord_obj_conex,
                Method.count(Medidores_Table.id.withTable(NameAlias.builder("B").build())).as("numMedidores"), Method.sum(IndicadoresLectura_Table.status_lectura).as("cant_lect_ejecutadas"))
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



        for (QueryObjetoConexion objetoConexion :
                list) {
            Log.e(TAG, "NUM MEDIDORES "+objetoConexion.getCant_lect_ejecutadas());
        }



        /**

        List<QueryObjetoConexion> list= new Select(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build()).as("id_objeto_conexion"),
                ObjetoConexion_Table.cod_obj_conex, ObjetoConexion_Table.nom_obj_conex, ObjetoConexion_Table.ord_obj_conex)
                .from(ObjetoConexion.class).as("A")
                .innerJoin(CalleAvenida.class).as("B")
                .on(ObjetoConexion_Table.id_calle_avenida.withTable(NameAlias.builder("A").build())
                        .eq(CalleAvenida_Table.id.withTable(NameAlias.builder("B").build())))
                .innerJoin(Ruta.class).as("C")
                .on(CalleAvenida_Table.id_ruta.withTable(NameAlias.builder("B").build())
                        .eq(Ruta_Table.id.withTable(NameAlias.builder("C").build())))
                .innerJoin(Parroquias.class).as("D")
                .on(CalleAvenida_Table.id_parroquia.withTable(NameAlias.builder("B").build())
                        .eq(Parroquias_Table.id_parroquia.withTable(NameAlias.builder("D").build())))
                .innerJoin(Municipios.class).as("E")
                .on(Parroquias_Table.id_municipio.withTable(NameAlias.builder("D").build())
                        .eq(Municipios_Table.id_municipio.withTable(NameAlias.builder("E").build())))
                .innerJoin(IndicadoresLectura.class).as("F")
                .on(ObjetoConexion_Table.id.withTable(NameAlias.builder("A").build())
                        .eq(IndicadoresLectura_Table.id_medidores.withTable(NameAlias.builder("F").build())))
                .orderBy(ObjetoConexion_Table.ord_obj_conex, true)
                .queryCustomList(QueryObjetoConexion.class);
        */

        ObjetosConexionEvent event= new ObjetosConexionEvent();
        event.setLista(list);
        event.setEventType(ObjetosConexionEvent.showListasObjetos);
        eventBus.post(event);

    }

    @Override
    public void onSelectObjeto(QueryObjetoConexion objeto) {
        sessionManager.setObjetoConexion(objeto);

        RecorridoEvent event= new RecorridoEvent();
        event.setEventType(RecorridoEvent.onClickObjetoConexion);
        eventBus.post(event);
    }

}