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
public class FRuta extends BaseModel{

    @Column
    @PrimaryKey
    int id;

    @Column
    String cod_edo_ruta;
    @Column
    String nom_edo_ruta;
    @Column
    int version;
    @Column
    int accion;
    @Column
    String desc_edo_ruta;
}
