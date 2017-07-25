package ve.gob.fundelec.simlec.ListaRutasAsignadas.adapter;


import ve.gob.fundelec.simlec.ListaRutasAsignadas.entities.QueryRutas;

/**
 * Created by root on 27/02/17.
 */

public interface OnItemClickListener {
    void onClickRuta(QueryRutas ruta);
    void onClickRutaMap(QueryRutas ruta);

}
