package ve.gob.fundelec.simlec;

import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by Eukaris on 12/04/2017.
 */
public class Configuracion {
    public static final int NOTASLECTURAUNIDADGESTIONAR=1;
    public static final int NOTASLECTURASTOMALECTURA=2;

    public enum TipoUsuario{
        LECTOR, ADMINISTRADOR, SUPERVISOR,
    }

    public enum PantallasRecorridoRutas {
        LISTA_RUTAS_ASIGNADAS, LISTA_CALLES_AVENIDAS, LISTA_CENTROS_MEDICION, LECTURA_GESTIONAR,
    }

    public enum StatusObjetoConexion{
        LEIDO, POR_LEER, EN_ESPERA,
    }

    public static void searh(EventBus eventBus){
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onSearch);
        eventBus.post(event);
    }

    public static void menu(EventBus eventBus){
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onButtonMenu);
        eventBus.post(event);
    }

    public static void back(EventBus eventBus){
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onBackPress);
        eventBus.post(event);
    }

    public static void letterS(EventBus eventBus){
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onClickSobrante);
        eventBus.post(event);
    }

    public static void letterP(EventBus eventBus){
        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.onClickPresinto);
        eventBus.post(event);
    }

}
