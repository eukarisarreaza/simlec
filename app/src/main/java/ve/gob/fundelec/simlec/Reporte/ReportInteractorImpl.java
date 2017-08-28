package ve.gob.fundelec.simlec.Reporte;

/**
 * Created by fundelec on 28/08/17.
 */

public class ReportInteractorImpl implements ReportInteractor {
    private ReportRepository reportRepository;

    public ReportInteractorImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
}
