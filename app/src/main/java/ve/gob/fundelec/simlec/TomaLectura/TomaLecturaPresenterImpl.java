package ve.gob.fundelec.simlec.TomaLectura;

import ve.gob.fundelec.simlec.TomaLectura.ui.TomaLecturaView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 10/08/17.
 */

public class TomaLecturaPresenterImpl implements TomaLecturaPresenter {
    private EventBus eventBus;
    private TomaLecturaView view;
    private TomaLecturaInteractor interactor;

    public TomaLecturaPresenterImpl(EventBus eventBus, TomaLecturaView view, TomaLecturaInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }




}
