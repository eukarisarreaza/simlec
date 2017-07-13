package ve.gob.fundelec.simlec.Main.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ve.gob.fundelec.simlec.Main.MainPressenter;
import ve.gob.fundelec.simlec.Main.adapter.AdaterMenuItem;
import ve.gob.fundelec.simlec.Main.adapter.ItemMenu;
import ve.gob.fundelec.simlec.R;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener{
    private static final String TAG=MainActivity.class.getName();
    private AdaterMenuItem adaterMenuItem;

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
        sertDrawer();
        setupInject();
        pressenter.onCreate();

    }

    private void setupInject() {


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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        pressenter.onDestroy();
    }
}
