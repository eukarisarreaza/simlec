package ve.gob.fundelec.simlec.Main;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ve.gob.fundelec.simlec.Configuracion;
import ve.gob.fundelec.simlec.LectorSessionManager;
import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;
import ve.gob.fundelec.simlec.Main.event.MainEvent;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/07/17.
 */

public class MainRepositoryImpl implements MainRepository {
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



    }

    @Override
    public void getListMenu() {
        List<ItemMenu> menu = new ArrayList<>();

        if(sessionManager.getTipoUser().equals(Configuracion.TipoUsuario.LECTOR.name())){
            menu.add(new ItemMenu(R.drawable.map_marker_radius, R.color.colorPrimary, context.getString(R.string.rutas_asignadas)));
            menu.add(new ItemMenu(R.drawable.clock_in, R.color.opcion1_2, context.getString(R.string.aparato_sobrante)));
            menu.add(new ItemMenu(R.drawable.campana, R.color.opcion1_3, context.getString(R.string.campa_a)));
            menu.add(new ItemMenu(R.drawable.chart_pie, R.color.opcion1_4, context.getString(R.string.reporte)));
            menu.add(new ItemMenu(R.drawable.cloud_sync, R.color.opcion1_5, context.getString(R.string.sincronizar)));
            menu.add(new ItemMenu(R.drawable.exit_to_app, R.color.opcion2_2, context.getString(R.string.salir)));
            menu.add(new ItemMenu(R.drawable.battery_charging, R.color.opcion2_3, context.getString(R.string.bateria)));
            menu.add(new ItemMenu(R.drawable.linterna, R.color.opcion2_4, context.getString(R.string.linterna)));
        }else
        if(sessionManager.getTipoUser().equals(Configuracion.TipoUsuario.SUPERVISOR.name())){
            menu.add(new ItemMenu(R.drawable.map_marker_radius, R.color.colorPrimary, context.getString(R.string.rutas_asignadas)));
            menu.add(new ItemMenu(R.drawable.chart_pie, R.color.opcion1_4,context. getString(R.string.reporte)));
            menu.add(new ItemMenu(R.drawable.cloud_sync, R.color.opcion1_5, context.getString(R.string.sincronizar)));
            menu.add(new ItemMenu(R.drawable.exit_to_app, R.color.opcion2_2, context.getString(R.string.salir)));
            menu.add(new ItemMenu(R.drawable.settings, R.color.opcion2_2, context.getString(R.string.ajustes)));
            menu.add(new ItemMenu(R.drawable.battery_charging, R.color.opcion2_3, context.getString(R.string.bateria)));
            menu.add(new ItemMenu(R.drawable.linterna, R.color.opcion2_4, context.getString(R.string.linterna)));
        }else
        if(sessionManager.getTipoUser().equals(Configuracion.TipoUsuario.ADMINISTRADOR.name())){
            menu.add(new ItemMenu(R.drawable.cloud_sync, R.color.opcion1_5, context.getString(R.string.sincronizar)));
            menu.add(new ItemMenu(R.drawable.exit_to_app, R.color.opcion2_2, context.getString(R.string.salir)));
            menu.add(new ItemMenu(R.drawable.settings, R.color.opcion2_2, context.getString(R.string.ajustes)));
            menu.add(new ItemMenu(R.drawable.battery_charging, R.color.opcion2_3, context.getString(R.string.bateria)));
            menu.add(new ItemMenu(R.drawable.linterna, R.color.opcion2_4, context.getString(R.string.linterna)));
        }

        MainEvent event= new MainEvent();
        event.setEventType(MainEvent.showListMenu);
        event.setList(menu);
        eventBus.postSticky(event);
    }


    private void postEvent(int type, String errorMessage){
        MainEvent event= new MainEvent();
        event.setEventType(type);
        if(errorMessage != null){
            event.setErrorMessage(errorMessage);
        }
        eventBus.postSticky(event);
    }



}
