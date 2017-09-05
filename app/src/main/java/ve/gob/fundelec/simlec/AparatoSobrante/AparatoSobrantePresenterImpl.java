package ve.gob.fundelec.simlec.AparatoSobrante;

import ve.gob.fundelec.simlec.AparatoSobrante.ui.AparatoSobranteView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 22/08/17.
 */

public class AparatoSobrantePresenterImpl implements AparatoSobrantePresenter{
    private EventBus eventBus;
    private AparatoSobranteInteractor interactor;
    private AparatoSobranteView view;

    public AparatoSobrantePresenterImpl(EventBus eventBus, AparatoSobranteInteractor interactor, AparatoSobranteView view) {
        this.eventBus = eventBus;
        this.interactor = interactor;
        this.view = view;
    }



}
