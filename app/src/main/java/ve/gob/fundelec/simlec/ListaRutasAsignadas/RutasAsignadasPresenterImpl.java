package ve.gob.fundelec.simlec.ListaRutasAsignadas;

import ve.gob.fundelec.simlec.ListaRutasAsignadas.ui.RutasAsignadasView;
import ve.gob.fundelec.simlec.lib.base.EventBus;

/**
 * Created by fundelec on 19/07/17.
 */

public class RutasAsignadasPresenterImpl implements RutasAsignadasPresenter{
    private EventBus eventBus;
    private RutasAsignadasView view;
    private RutasAsignadasInteractor interactor;


    public RutasAsignadasPresenterImpl(EventBus eventBus, RutasAsignadasView view, RutasAsignadasInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }



}
