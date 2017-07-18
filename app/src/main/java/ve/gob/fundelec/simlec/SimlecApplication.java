package ve.gob.fundelec.simlec;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

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
import ve.gob.fundelec.simlec.Services.di.ServiceModule;
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






}
