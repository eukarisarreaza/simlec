package ve.gob.fundelec.simlec.LecturaGestionar;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Date;
import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetoConexion_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetosConexionNotas;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetosConexionNotas_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.LecturaGestionar.event.LecturaGestionarEvent;
import ve.gob.fundelec.simlec.ListMedidores.event.LecturasEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class LecturaGestionarRepositoryImpl implements LecturaGestionarRepository {
    private static final String TAG= LecturaGestionarRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    private List<FNotaLectura> notasLectura; /** NOTAS DE LECTURA PARA LA UNIDADES DE LECTURA A GESTIONAR */

    public LecturaGestionarRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
    }

    @Override
    public void getInfoRuta() {
        /** OBTENER LA SIG INFORMACION: COD-RUTA, AREA, UNIDAD-LECTURA, MUNICIPIO, PARROQUIA, URBANIZACION,
         * CALLE, TEXTO-EXPLICATIVO
         **/
        LecturaGestionarEvent event= new LecturaGestionarEvent();
        event.setEventType(LecturaGestionarEvent.showInfoRuta);
        event.setRuta(sessionManager.getRuta());
        event.setCalle(sessionManager.getCalle());
        event.setObjetoConexion(sessionManager.getObjetConexion());
        eventBus.post(event);
    }

    @Override
    public void getNotasLectura() {

        notasLectura= new Select()
                .from(FNotaLectura.class)
                .where(FNotaLectura_Table.clas_nota_lectura.is(Configuracion.NOTASLECTURAUNIDADGESTIONAR))
                .queryList();
        String[] data= new String[notasLectura.size()];

        for (int i=0; i<notasLectura.size(); i++) {
            FNotaLectura aux= notasLectura.get(i);
            data[i]=aux.getCod_nota_letura()+" "+aux.getNom_nota_lectura();
        }

        LecturaGestionarEvent event= new LecturaGestionarEvent();
        event.setEventType(LecturaGestionarEvent.showListNotas);
        event.setNotasLectura(data);
        eventBus.post(event);
    }

    @Override
    public void grabarNotaUnidadLectura(int pos) {
        Log.e(TAG, "objeto de conexion actual "+sessionManager.getObjetConexion().getNom_obj_conex());
        Log.e(TAG, "nota lectura "+notasLectura.get(pos-1).getCod_nota_letura());


        ObjetosConexionNotas notaObjetoConexion= new Select(ObjetosConexionNotas_Table.ALL_COLUMN_PROPERTIES)
                .from(ObjetosConexionNotas.class)
                .where(ObjetosConexionNotas_Table.id_objeto_conexion.is(sessionManager.getObjetConexion().getId_objeto_conexion()))
                .querySingle();

        if(notaObjetoConexion==null){
            //Para efectos del demo, se crear un ObjetoConexionNota
            Math.random();
            ObjetosConexionNotas objetosConexionNotas= new ObjetosConexionNotas();
            objetosConexionNotas.setId((int) (Math.random()*22345565+1));
            objetosConexionNotas.setId_objeto_conexion(sessionManager.getObjetConexion().getId_objeto_conexion());
            objetosConexionNotas.setFch_lectura(new Date());
            objetosConexionNotas.setCod_nota_lectura(notasLectura.get(pos-1).getCod_nota_letura());
            objetosConexionNotas.setId_programacion_calle(sessionManager.getCalle().getId_programacion_calle());
            objetosConexionNotas.setVersion(1);
            objetosConexionNotas.setVersion(1);
            objetosConexionNotas.save();
            Log.e(TAG, "objeto conexion nota no existe, creado ");
        }else
            Log.e(TAG, "objeto conexion nota "+notaObjetoConexion.toString());

        /**
        notaObjetoConexion.setCod_nota_lectura(notasLectura.get(pos-/1).getCod_nota_letura());
        notaObjetoConexion.save();

        LecturaGestionarEvent event= new LecturaGestionarEvent();
        event.setEventType(LecturaGestionarEvent.onSussesGrabarNota);
        eventBus.post(event);*/
    }

    @Override
    public void onSelectObjeto() {
        LecturasEvent event= new LecturasEvent();
        event.setEventType(LecturasEvent.selectObjetoConexion);
        eventBus.post(event);
    }

}
