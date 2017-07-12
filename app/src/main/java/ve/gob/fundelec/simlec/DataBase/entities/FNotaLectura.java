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
public class FNotaLectura extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    String cod_nota_letura;
    @Column
    String nom_nota_lectura;
    @Column
    String desc_nota_lectura;
    @Column
    int clas_nota_lectura;
    @Column
    int version;
    @Column
    int accion;
    @Column
    int crit_nota_lectura;
    @Column
    String impl_nota_lectura;

}
