package ve.gob.fundelec.simlec.TomaLectura;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura;
import ve.gob.fundelec.simlec.DataBase.entities.FNotaLectura_Table;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.TomaLectura.event.TomaLecturaEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaRepositoryImpl implements TomaLecturaRepository{
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    private List<FNotaLectura> notasLectura; /** NOTAS DE LECTURA PARA LA TOMA DE LECTURA */

    public TomaLecturaRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
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
        eventBus.post(event);
    }

    @Override
    public void grabarNotaLectura(int pos) {



    }

    @Override
    public void grabarLectura(String lectura) {




    }
}
