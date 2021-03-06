package ve.gob.fundelec.simlec.Main;

import android.content.Context;
import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.DataBase.entities.Parroquias;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;
import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainRepositoryImpl implements MainRepository {
    private static final String TAG= MainRepositoryImpl.class.getName();
    private EventBus eventBus;
    private LectorSessionManager sessionManager;
    private Context context;

    public MainRepositoryImpl(EventBus eventBus, LectorSessionManager sessionManager, Context context) {
        this.eventBus = eventBus;
        this.sessionManager = sessionManager;
        this.context = context;
    }

    @Override
    public void getInicio() {
        // envia al preserter el ultimo fragment en RutasAsignadas

        /**
        List<Parroquias> parroquiasList = SQLite.select().
                from(Parroquias.class).queryList();

        for (Parroquias item: parroquiasList) {
            Log.e(TAG, "parroquia "+item.getParroquia());
        }
        */
        postEventInicio(MainEvent.showFragmentInicio, sessionManager.getKeyRuta());
    }

    @Override
    public void getListMenu() {
        List<ItemMenu> menu = new ArrayList<>();

        if(sessionManager.getUser().getRol_operador()==1){ /** LECTOR **/
            menu.add(new ItemMenu(R.drawable.map_marker_radius, R.color.colorPrimary, context.getString(R.string.rutas_asignadas)));
            menu.add(new ItemMenu(R.drawable.clock_in, R.color.opcion1_2, context.getString(R.string.aparato_sobrante)));
            menu.add(new ItemMenu(R.drawable.campana, R.color.opcion1_3, context.getString(R.string.campa_a)));
            menu.add(new ItemMenu(R.drawable.chart_pie, R.color.opcion1_4, context.getString(R.string.reporte)));
            menu.add(new ItemMenu(R.drawable.cloud_sync, R.color.opcion1_5, context.getString(R.string.sincronizar)));
            menu.add(new ItemMenu(R.drawable.exit_to_app, R.color.opcion2_2, context.getString(R.string.salir)));
            //menu.add(new ItemMenu(R.drawable.battery_charging, R.color.opcion2_3, context.getString(R.string.bateria)));
            menu.add(new ItemMenu(R.drawable.linterna, R.color.opcion2_4, context.getString(R.string.linterna)));
        }else
        if(sessionManager.getUser().getRol_operador()==2){ /** SUPERVISOR */
            menu.add(new ItemMenu(R.drawable.map_marker_radius, R.color.colorPrimary, context.getString(R.string.rutas_asignadas)));
            menu.add(new ItemMenu(R.drawable.chart_pie, R.color.opcion1_4,context. getString(R.string.reporte)));
            menu.add(new ItemMenu(R.drawable.cloud_sync, R.color.opcion1_5, context.getString(R.string.sincronizar)));
            menu.add(new ItemMenu(R.drawable.exit_to_app, R.color.opcion2_2, context.getString(R.string.salir)));
            menu.add(new ItemMenu(R.drawable.settings, R.color.opcion2_2, context.getString(R.string.ajustes)));
            //menu.add(new ItemMenu(R.drawable.battery_charging, R.color.opcion2_3, context.getString(R.string.bateria)));
            menu.add(new ItemMenu(R.drawable.linterna, R.color.opcion2_4, context.getString(R.string.linterna)));
        }else
        if(sessionManager.getUser().getRol_operador()==3){ /** ADMINISTRADOR */
            menu.add(new ItemMenu(R.drawable.cloud_sync, R.color.opcion1_5, context.getString(R.string.sincronizar)));
            menu.add(new ItemMenu(R.drawable.exit_to_app, R.color.opcion2_2, context.getString(R.string.salir)));
            menu.add(new ItemMenu(R.drawable.settings, R.color.opcion2_2, context.getString(R.string.ajustes)));
            //menu.add(new ItemMenu(R.drawable.battery_charging, R.color.opcion2_3, context.getString(R.string.bateria)));
            menu.add(new ItemMenu(R.drawable.linterna, R.color.opcion2_4, context.getString(R.string.linterna)));
        }

        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.showListMenu);
        event.setList(menu);
        eventBus.postSticky(event);
    }

    @Override
    public void retroceder() {
        if(sessionManager.getKeyRuta().equals(Configuracion.PantallasRecorridoRutas.LISTA_CALLES_AVENIDAS.name())){
            sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LISTA_RUTAS_ASIGNADAS);
        }else
        if(sessionManager.getKeyRuta().equals(Configuracion.PantallasRecorridoRutas.LISTA_CENTROS_MEDICION.name())){
            sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LISTA_CALLES_AVENIDAS);
        }else
        if(sessionManager.getKeyRuta().equals(Configuracion.PantallasRecorridoRutas.LECTURA_GESTIONAR.name())){
            sessionManager.setRecorrido(Configuracion.PantallasRecorridoRutas.LISTA_CENTROS_MEDICION);
        }
    }


    private void postEvent(int type, String errorMessage){
        MainEvent event= new MainEvent();
        event.setEventType(type);
        if(errorMessage != null){
            event.setErrorMessage(errorMessage);
        }
        eventBus.post(event);
    }

    private void postEventInicio(int type, String fragment){
        MainEvent event= new MainEvent();
        event.setEventType(type);
        event.setFragment(fragment);
        eventBus.post(event);
    }

}
