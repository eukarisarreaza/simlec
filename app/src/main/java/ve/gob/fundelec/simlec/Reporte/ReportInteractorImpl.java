package ve.gob.fundelec.simlec.Reporte;

import ve.gob.fundelec.simlec.ListaCallesAvenidas.entities.QueryCalles;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportInteractorImpl implements ReportInteractor {
    private ReportRepository reportRepository;

    public ReportInteractorImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void getListRutas() {
        reportRepository.getListRutas();
    }

    @Override
    public void onSelectCalle(QueryCalles calle) {
        reportRepository.getReport(calle);
    }
}
