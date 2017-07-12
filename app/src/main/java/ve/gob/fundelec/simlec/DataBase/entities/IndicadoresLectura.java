package ve.gob.fundelec.simlec.DataBase.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 11/07/17.
 */
@Table(database = DataBaseSimlec.class)
public class IndicadoresLectura extends BaseModel {


    @Column
    @PrimaryKey
    int id;

    @Column
    int id_medidores; // clave foranea hace referencia a medidores
    @Column
    int id_programacion_calle; // clave foranea programacion_calle (id)
    @Column
    String cod_nota_lectura;
    @Column
    String fch_lectura; //date
    @Column
    String long_lat;

    @Column
    double lim_super_kwh;
    @Column
    double lim_infer_kwh;
    @Column
    double lim_super_va;
    @Column
    double lim_infer_va;
    @Column
    double lectura_prevista;
    @Column
    double consumo_kwh;
    @Column
    double demanda_va;

    @Column
    int version;
    @Column
    int accion;
    @Column
    String fch_toma_lectura; // timestamp without time zone,



}
