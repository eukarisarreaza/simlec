package ve.gob.fundelec.simlec.AparatoSobrante.di;

import dagger.Module;
import ve.gob.fundelec.simlec.AparatoSobrante.ui.AparatoSobranteView;

/**
 * Created by fundelec on 14/07/17.
 */
@Module
public class AparatoSobranteModule {
    private AparatoSobranteView view;

    public AparatoSobranteModule(AparatoSobranteView view) {
        this.view = view;
    }




}
