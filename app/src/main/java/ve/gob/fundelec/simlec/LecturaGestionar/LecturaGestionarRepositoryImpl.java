package ve.gob.fundelec.simlec.LecturaGestionar;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura_Table;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetosConexionNotas;
import ve.gob.fundelec.simlec.DataBase.entities.ObjetosConexionNotas_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.LecturaGestionar.event.LecturaGestionarEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class LecturaGestionarRepositoryImpl implements LecturaGestionarRepository {
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

        ObjetosConexionNotas notaObjetoConexion= new Select()
                .from(ObjetosConexionNotas.class)
                .where(ObjetosConexionNotas_Table.id_objeto_conexion.is(sessionManager.getObjetConexion().getId_objeto_conexion()))
                .querySingle();

        notaObjetoConexion.setCod_nota_lectura(notasLectura.get(pos-1).getCod_nota_letura());
        notaObjetoConexion.save();

        LecturaGestionarEvent event= new LecturaGestionarEvent();
        event.setEventType(LecturaGestionarEvent.onSussesGrabarNota);
        eventBus.post(event);

    }

}
