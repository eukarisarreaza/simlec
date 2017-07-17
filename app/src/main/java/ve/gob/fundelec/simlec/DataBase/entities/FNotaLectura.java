package ve.gob.fundelec.simlec.DataBase.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 11/07/17.
 */
/**
CREATE TABLE f_nota_lectura
(
  id bigint NOT NULL DEFAULT nextval('f_nota_lectura_id_seq'::regclass),
  cod_nota_letura character varying(2) NOT NULL,
  nom_nota_lectura character varying(50) NOT NULL,
  desc_nota_lectura text NOT NULL,
  clas_nota_lectura integer NOT NULL,
  version bigint,
  accion integer,
  crit_nota_lectura integer NOT NULL,
  impl_nota_lectura text,
  CONSTRAINT pkf_nota_lectura PRIMARY KEY (id)
)
 */
@Table(database = DataBaseSimlec.class)
public class FNotaLectura extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    String cod_nota_letura; // limite de 2
    @Column
    String nom_nota_lectura; // limite de 50
    @Column
    String desc_nota_lectura;
    @Column
    int clas_nota_lectura;
    @Column
    int crit_nota_lectura;
    @Column
    String impl_nota_lectura;

    @Column
    int version;
    @Column
    int accion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_nota_letura() {
        return cod_nota_letura;
    }

    public void setCod_nota_letura(String cod_nota_letura) {
        this.cod_nota_letura = cod_nota_letura;
    }

    public String getNom_nota_lectura() {
        return nom_nota_lectura;
    }

    public void setNom_nota_lectura(String nom_nota_lectura) {
        this.nom_nota_lectura = nom_nota_lectura;
    }

    public String getDesc_nota_lectura() {
        return desc_nota_lectura;
    }

    public void setDesc_nota_lectura(String desc_nota_lectura) {
        this.desc_nota_lectura = desc_nota_lectura;
    }

    public int getClas_nota_lectura() {
        return clas_nota_lectura;
    }

    public void setClas_nota_lectura(int clas_nota_lectura) {
        this.clas_nota_lectura = clas_nota_lectura;
    }

    public int getCrit_nota_lectura() {
        return crit_nota_lectura;
    }

    public void setCrit_nota_lectura(int crit_nota_lectura) {
        this.crit_nota_lectura = crit_nota_lectura;
    }

    public String getImpl_nota_lectura() {
        return impl_nota_lectura;
    }

    public void setImpl_nota_lectura(String impl_nota_lectura) {
        this.impl_nota_lectura = impl_nota_lectura;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
}
