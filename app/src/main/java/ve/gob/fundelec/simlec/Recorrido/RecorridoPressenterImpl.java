package ve.gob.fundelec.simlec.Recorrido;

import ve.gob.fundelec.simlec.Recorrido.ui.RecorridoView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 01/08/17.
 */

public class RecorridoPressenterImpl implements RecorridoPressenter{
    private static final String TAG= RecorridoPressenterImpl.class.getName();
    private EventBus eventBus;
    private RecorridoView view;
    private RecorridoInteractor interactor;


    public RecorridoPressenterImpl(EventBus eventBus, RecorridoView view, RecorridoInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
