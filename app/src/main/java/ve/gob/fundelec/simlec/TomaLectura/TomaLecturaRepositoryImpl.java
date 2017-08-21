package ve.gob.fundelec.simlec.TomaLectura;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Date;
import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura;
import ve.gob.fundelec.simlec.DataBase.entities.IndicadoresLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.Medidores;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle;
import ve.gob.fundelec.simlec.DataBase.entities.ProgramacionCalle_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.ListMedidores.entities.QueryMedidores;
import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaRepositoryImpl implements TomaLecturaRepository{
    private static final String TAG= TomaLecturaRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    private List<FNotaLectura> notasLectura; /** NOTAS DE LECTURA PARA LA TOMA DE LECTURA */
    private QueryMedidores medidor;

    public TomaLecturaRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
        this.medidor = sessionManager.getMedidor();
        // obtener el objeto programacion calle
    }

    public void setProgramacion() {
        /*
        programacionCalle = new Select(ProgramacionCalle_Table.ALL_COLUMN_PROPERTIES)
                .from(ProgramacionCalle.class)
                .where(ProgramacionCalle_Table.id.is(sessionManager.getCalle().getId_programacion_calle()))
                .querySingle();
        Log.e(TAG, "programacion calle "+programacionCalle.toString());

                */
        Log.e(TAG, "id programacion calle "+sessionManager.getCalle().getId_programacion_calle());

    }
    @Override
    public void getNotasLectura() {

        notasLectura= new Select()
                .from(FNotaLectura.class)
                .where(FNotaLectura_Table.clas_nota_lectura.is(Configuracion.NOTASLECTURASTOMALECTURA))
                .queryList();

        String[] data= new String[notasLectura.size()];

        for (int i=0; i<notasLectura.size(); i++) {
            FNotaLectura aux= notasLectura.get(i);
            data[i]=aux.getCod_nota_letura()+" "+aux.getNom_nota_lectura();
        }

        TomaLecturaEvent event= new TomaLecturaEvent();
        event.setEventType(TomaLecturaEvent.showListNotas);
        event.setNotasLectura(data);
        eventBus.post(event);
    }

    @Override
    public void getInfoRuta() {
        TomaLecturaEvent event= new TomaLecturaEvent();
        event.setEventType(TomaLecturaEvent.showInfoRuta);
        event.setRuta(sessionManager.getRuta());
        event.setObjetoConexion(sessionManager.getObjetConexion());
        eventBus.post(event);

    }

    @Override
    public void grabarNotaLectura(int pos) {
        //Log.e(TAG, "nota lectura "+notasLectura.get(pos-1).getCod_nota_letura());

        IndicadoresLectura lectura_table= new Select()
                .from(IndicadoresLectura.class)
                .where(IndicadoresLectura_Table.id.is(medidor.getId_indicador_lectura()))
                .querySingle();
        lectura_table.setCod_nota_lectura(notasLectura.get(pos-1).getCod_nota_letura());
        lectura_table.save();

        Log.e(TAG, "nota lectura "+lectura_table.toString());
    }



    @Override
    public void getParametrosLectura() {
        TomaLecturaEvent event= new TomaLecturaEvent();
        event.setEventType(TomaLecturaEvent.showInfoMedidor);
        event.setMedidor(sessionManager.getMedidor());
        eventBus.post(event);
    }

    @Override
    public void getIndicadoresLectura() {
        IndicadoresLectura lectura= new Select(IndicadoresLectura_Table.ALL_COLUMN_PROPERTIES)
                .from(IndicadoresLectura.class)
                .where(IndicadoresLectura_Table.id_medidores.is(sessionManager.getMedidor().getId_medidor()))
                .querySingle();

        if(lectura.getConsumo_kwh()!= 0 && lectura.getDemanda_va()!= 0 ){
            TomaLecturaEvent event= new TomaLecturaEvent();
            event.setEventType(TomaLecturaEvent.showInfoIndicadorLectura);
            event.setKva(String.valueOf(lectura.getConsumo_kwh()));
            event.setVa(String.valueOf(lectura.getDemanda_va()));
            eventBus.post(event);
        }
    }

    @Override
    public void saveLectura(String lectura1, String lectura2) {
        if(lectura1.isEmpty() || lectura2.isEmpty()){
            TomaLecturaEvent event= new TomaLecturaEvent();
            event.setEventType(TomaLecturaEvent.onFailedGrabarLcetura);
            eventBus.post(event);
            return;
        }

        try{
            double lect1 =Double.parseDouble(lectura1);
            double lect2 =Double.parseDouble(lectura2);

            IndicadoresLectura lectura= new Select(IndicadoresLectura_Table.ALL_COLUMN_PROPERTIES)
                    .from(IndicadoresLectura.class)
                    .where(IndicadoresLectura_Table.id_medidores.is(sessionManager.getMedidor().getId_medidor()))
                    .querySingle();


            Log.e(TAG,"Indicador de lectura "+lectura.toString());

            lectura.setFch_toma_lectura(new Date());
            lectura.setConsumo_kwh(lect1);
            lectura.setDemanda_va(lect2);
            lectura.setStatus_lectura(1); /** TODO STUB: ACTUALIZAR OBJETO DE CONEXION DESPUES DE G*/
            lectura.save();

            Log.e(TAG,"Indicador de lectura actualizada "+lectura.toString());

            TomaLecturaEvent event= new TomaLecturaEvent();
            event.setEventType(TomaLecturaEvent.onSussesGrabarLectura);
            eventBus.post(event);

        }catch (Exception e){
            TomaLecturaEvent event= new TomaLecturaEvent();
            event.setEventType(TomaLecturaEvent.onFailedGrabarLcetura);
            eventBus.post(event);

        }finally {

        }

    }


}
