package ve.gob.fundelec.simlec;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import ve.gob.fundelec.simlec.AparatoSobrante.di.AparatoSobranteComponent;
import ve.gob.fundelec.simlec.AparatoSobrante.di.AparatoSobranteModule;
import ve.gob.fundelec.simlec.AparatoSobrante.di.DaggerAparatoSobranteComponent;
import ve.gob.fundelec.simlec.AparatoSobrante.ui.AparatoSobranteView;
import ve.gob.fundelec.simlec.Campaña.di.CampanaComponent;
import ve.gob.fundelec.simlec.Campaña.di.CampanaModule;
import ve.gob.fundelec.simlec.Campaña.di.DaggerCampanaComponent;
import ve.gob.fundelec.simlec.Campaña.ui.CampanaView;
import ve.gob.fundelec.simlec.LecturaGestionar.di.DaggerLecturaGestionarComponent;
import ve.gob.fundelec.simlec.LecturaGestionar.di.LecturaGestionarComponent;
import ve.gob.fundelec.simlec.LecturaGestionar.di.LecturaGestionarModule;
import ve.gob.fundelec.simlec.LecturaGestionar.ui.LecturaGestionarView;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.adapter.OnClickCallesAvenidas;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.di.CallesAvenidasComponent;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.di.CallesAvenidasModule;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.di.DaggerCallesAvenidasComponent;
import ve.gob.fundelec.simlec.ListaCallesAvenidas.ui.CallesAvenidasView;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.adapter.OnItemClickListener;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.di.DaggerRutasAsignadasComponent;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.di.RutasAsignadasComponent;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.di.RutasAsignadasModule;
import ve.gob.fundelec.simlec.ListaRutasAsignadas.ui.RutasAsignadasView;
import ve.gob.fundelec.simlec.Login.di.ContextModule;
import ve.gob.fundelec.simlec.Login.di.DaggerLoginComponent;
import ve.gob.fundelec.simlec.Login.di.LoginComponent;
import ve.gob.fundelec.simlec.Login.di.LoginModule;
import ve.gob.fundelec.simlec.Login.di.SesionModule;
import ve.gob.fundelec.simlec.Login.ui.LoginView;
import ve.gob.fundelec.simlec.Main.di.DaggerMainComponent;
import ve.gob.fundelec.simlec.Main.di.MainComponent;
import ve.gob.fundelec.simlec.Main.di.MainModule;
import ve.gob.fundelec.simlec.Main.ui.MainView;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.di.DaggerObjetosConexionComponent;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.di.ObjetosConexionComponent;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.di.ObjetosConexionModule;
import ve.gob.fundelec.simlec.ListadoCentrosMedicion.ui.ObjetosConexionView;
import ve.gob.fundelec.simlec.ListMedidores.di.DaggerRecorridoComponent;
import ve.gob.fundelec.simlec.ListMedidores.di.RecorridoComponent;
import ve.gob.fundelec.simlec.ListMedidores.di.RecorridoModule;
import ve.gob.fundelec.simlec.ListMedidores.ui.RecorridoView;
import ve.gob.fundelec.simlec.Reporte.di.DaggerReportComponent;
import ve.gob.fundelec.simlec.Reporte.di.ReportComponent;
import ve.gob.fundelec.simlec.Reporte.di.ReportModule;
import ve.gob.fundelec.simlec.Reporte.ui.ReportView;
import ve.gob.fundelec.simlec.Services.di.ServiceModule;
import ve.gob.fundelec.simlec.TomaLectura.di.DaggerTomaLecturaComponent;
import ve.gob.fundelec.simlec.TomaLectura.di.TomaLecturaComponent;
import ve.gob.fundelec.simlec.TomaLectura.di.TomaLecturaModule;
import ve.gob.fundelec.simlec.TomaLectura.ui.TomaLecturaView;
import ve.gob.fundelec.simlec.lib.di.LibsModule;

/**
 * Created by fundelec on 10/07/17.
 */

public class SimlecApplication extends Application {
    private static final String BASE_URL= "http://4d-investment.kontabiliza.com.ve/api/public/";

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).build());
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/arial.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

    public LoginComponent getLoginComponent(LoginView view){
        return DaggerLoginComponent
                .builder()
                .libsModule(new LibsModule())
                .loginModule(new LoginModule(view))
                .serviceModule(new ServiceModule(BASE_URL))
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public MainComponent getMainComponent(MainView view){
        return DaggerMainComponent
                .builder()
                .libsModule(new LibsModule())
                .mainModule(new MainModule(view))
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public RutasAsignadasComponent getRutasAsignadasComponent(RutasAsignadasView view, OnItemClickListener listener){
        return DaggerRutasAsignadasComponent
                .builder()
                .rutasAsignadasModule(new RutasAsignadasModule(view, listener))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public CallesAvenidasComponent getCallesAvenidasComponent(CallesAvenidasView view, OnClickCallesAvenidas listener){
        return DaggerCallesAvenidasComponent
                .builder()
                .libsModule(new LibsModule())
                .callesAvenidasModule(new CallesAvenidasModule(view, listener))
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public ObjetosConexionComponent getObjetosConexionComponent(ObjetosConexionView view){
        return DaggerObjetosConexionComponent
                .builder()
                .objetosConexionModule(new ObjetosConexionModule(view))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public RecorridoComponent getRecorridoComponent(RecorridoView view){
        return DaggerRecorridoComponent
                .builder()
                .recorridoModule(new RecorridoModule(view))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }


    public LecturaGestionarComponent getLecturaGestionarComponent(LecturaGestionarView view) {

        return DaggerLecturaGestionarComponent
                .builder()
                .lecturaGestionarModule(new LecturaGestionarModule(view))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public TomaLecturaComponent getTomaLecturaComponent(TomaLecturaView view){

        return DaggerTomaLecturaComponent
                .builder()
                .tomaLecturaModule(new TomaLecturaModule(view))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }


    public ReportComponent getReportComponent(ReportView view){
        return DaggerReportComponent
                .builder()
                .reportModule(new ReportModule(view))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public AparatoSobranteComponent getAparatoSobranteComponent(AparatoSobranteView view){
        return DaggerAparatoSobranteComponent
                .builder()
                .libsModule(new LibsModule())
                .aparatoSobranteModule(new AparatoSobranteModule(view))
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public CampanaComponent getCampanaComponent(CampanaView view){
        return DaggerCampanaComponent
                .builder()
                .campanaModule(new CampanaModule(view))
                .libsModule(new LibsModule())
                .sesionModule(new SesionModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }
}
