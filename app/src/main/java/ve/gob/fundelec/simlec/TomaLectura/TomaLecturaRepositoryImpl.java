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
    private ProgramacionCalle programacionCalle;

    public TomaLecturaRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
        this.medidor = sessionManager.getMedidor();
        // obtener el objeto programacion calle
        setProgramacion();
    }

    public void setProgramacion() {
        programacionCalle = new Select(ProgramacionCalle_Table.ALL_COLUMN_PROPERTIES)
                .from(ProgramacionCalle.class)
                .where(ProgramacionCalle_Table.id.is(sessionManager.getCalle().getId_programacion_calle()))
                .querySingle();

        Log.e(TAG, "programacion calle "+programacionCalle.toString());
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
    public void grabarLecturaKva(String lectura) {
        IndicadoresLectura lectura_table= new Select()
                .from(IndicadoresLectura.class)
                .where(IndicadoresLectura_Table.id.is(medidor.getId_indicador_lectura()))
                .querySingle();

        Log.e(TAG,"lectura a grabar (consumo kwh)"+Double.parseDouble(lectura));
        lectura_table.setConsumo_kwh(Double.parseDouble(lectura));
        lectura_table.save();
        Log.e(TAG,"lectura grabada"+lectura_table.toString());
    }

    @Override
    public void grabarLecturaVa(String lectura) {
        IndicadoresLectura lectura_table= new Select()
                .from(IndicadoresLectura.class)
                .where(IndicadoresLectura_Table.id.is(medidor.getId_indicador_lectura()))
                .querySingle();

        Log.e(TAG,"lectura a grabar (demanda VA) "+Double.parseDouble(lectura));
        lectura_table.setDemanda_va(Double.parseDouble(lectura));
        lectura_table.save();
        Log.e(TAG,"lectura grabada"+lectura_table.toString());
    }

    @Override
    public void actualizarFechaLectura() {
        IndicadoresLectura lectura_table= new Select()
                .from(IndicadoresLectura.class)
                .where(IndicadoresLectura_Table.id.is(medidor.getId_indicador_lectura()))
                .querySingle();

        lectura_table.setFch_toma_lectura(new Date());
        lectura_table.save();
        Log.e(TAG,"lectura grabada"+lectura_table.toString());

    }

    @Override
    public void getParametrosLectura() {
        TomaLecturaEvent event= new TomaLecturaEvent();
        event.setEventType(TomaLecturaEvent.showInfoMedidor);
        event.setMedidor(sessionManager.getMedidor());
        eventBus.post(event);
    }


}
