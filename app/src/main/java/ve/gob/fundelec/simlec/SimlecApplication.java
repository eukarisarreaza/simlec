package ve.gob.fundelec.simlec;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by fundelec on 10/07/17.
 */

public class SimlecApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).build());





    }







}
