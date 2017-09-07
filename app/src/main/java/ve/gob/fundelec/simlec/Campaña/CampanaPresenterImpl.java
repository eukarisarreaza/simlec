package ve.gob.fundelec.simlec.Campaña;


import ve.gob.fundelec.simlec.Campaña.ui.CampanaView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 14/07/17.
 */

public class CampanaPresenterImpl implements CampanaPresenter {
    private EventBus eventBus;
    private CampanaInteractor interactor;
    private CampanaView view;

    public CampanaPresenterImpl(EventBus eventBus, CampanaInteractor interactor, CampanaView view) {
        this.eventBus = eventBus;
        this.interactor = interactor;
        this.view = view;
    }





}
