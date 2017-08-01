package ve.gob.fundelec.simlec.Main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.AparatoSobrante.ui.AparatoSobranteFragment;
import ve.gob.fundelec.simlec.Campaña.ui.CampanaFragment;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.ui.CallesAvenidasFragment;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.ui.RutasAsignadasFragment;
import ve.gob.fundelec.simlec.Login.ui.LoginActivity;
import ve.gob.fundelec.simlec.Main.MainPressenter;
import ve.gob.fundelec.simlec.Main.adapter.AdaterMenuItem;
import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;
import ve.gob.fundelec.simlec.Main.di.MainComponent;
import ve.gob.fundelec.simlec.ListaObjetosConexion.ui.ObjetosConexionFragment;
import ve.gob.fundelec.simlec.R;
import ve.gob.fundelec.simlec.SimlecApplication;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener{
    private static final String TAG=MainActivity.class.getName();
    private AdaterMenuItem adaterMenuItem;
    private boolean isChecked;

    @BindView(R.id.list_item)
    ListView listItem;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Inject
    MainPressenter pressenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isChecked= true;

        sertDrawer();
        setupInject();
        pressenter.onCreate();
        pressenter.getListItenMenu();
        pressenter.getInicio();
    }

    private void setupInject() {
        SimlecApplication application= (SimlecApplication) getApplication();
        MainComponent component= application.getMainComponent(this);
        component.inject(this);
    }

    private void sertDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        View view = getLayoutInflater().inflate(R.layout.nav_header_main, null);
        listItem.addHeaderView(view);
        List<ItemMenu> list= new ArrayList<>();
        adaterMenuItem = new AdaterMenuItem(getApplicationContext(), list);
        listItem.setAdapter(adaterMenuItem);
        listItem.setOnItemClickListener(this);
    }


    @Override
    public void showListOpciones(List<ItemMenu> list) {
        adaterMenuItem.setList(list);
    }

    @Override
    public void listaRutasAsignadas() {
        isChecked=true;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, RutasAsignadasFragment.newInstance())
                .commit();
    }

    @Override
    public void listaCallesAvenidas() {
        isChecked=true;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, CallesAvenidasFragment.newInstance())
                .commit();
    }

    @Override
    public void listaObjetosConexion() {
        isChecked=true;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, ObjetosConexionFragment.newInstance())
                .commit();
    }

    @Override
    public void lecturaGestionar() {
        isChecked=true;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, AparatoSobranteFragment.newInstance())
                .commit();
    }


    @Override
    public void aparatoSobrante() {
        isChecked=false;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, AparatoSobranteFragment.newInstance())
                .commit();
    }

    @Override
    public void campaña() {
        isChecked=false;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, CampanaFragment.newInstance())
                .commit();
    }

    @Override
    public void reporte() {
        isChecked=false;

    }

    @Override
    public void sincronizar() {
        isChecked=false;

    }

    @Override
    public void salir() {
        /** CERRAR SESION E IR A LA PANTALLA DE LOGIN */
        pressenter.salir();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        finish();
    }

    @Override
    public void bateria() {

    }

    @Override
    public void linterna() {

    }

    @Override
    public void onBackPress() {
        if(drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.closeDrawer(Gravity.RIGHT);
            return;
        }
        if (isChecked){
            pressenter.onBackPress();
        }else
            super.onBackPressed();
    }

    @Override
    public void onButtonMenu() {
        if(!drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.openDrawer(Gravity.RIGHT);
        }
    }

    @Override
    public void onClickPresinto() {

    }

    @Override
    public void onClickSobrante() {

    }

    @Override
    public void onSearch() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
            return;

        drawer.closeDrawer(Gravity.RIGHT);

        ItemMenu menu= adaterMenuItem.getItem(position-1);

        if(menu.getTexto().equals("Rutas Asignadas")){
            pressenter.getInicio();
        }else
        if(menu.getTexto().equals("Aparato Sobrante")) {
            aparatoSobrante();
        }else
        if(menu.getTexto().equals("Campaña")) {
            campaña();
        }else
        if(menu.getTexto().equals("Reporte")) {
            reporte();
        }else
        if(menu.getTexto().equals("Sincronizar")) {
            sincronizar();
        }else
        if(menu.getTexto().equals("Salir")) {
            salir();
        }else
        if(menu.getTexto().equals("Bateria")) {
            bateria();
        }else
        if(menu.getTexto().equals("Linterna")) {
            linterna();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        pressenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        onBackPress();
    }
}
