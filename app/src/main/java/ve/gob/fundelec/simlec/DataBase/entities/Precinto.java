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
CREATE TABLE precinto
(
  id bigint NOT NULL DEFAULT nextval('precinto_id_seq'::regclass),
  id_medidores bigint NOT NULL,
  fch_cambio timestamp without time zone NOT NULL,
  pre_medidor_actual character varying(20),
  pre_medidor_nuevo character varying(20),
  version bigint,
  accion integer,
  CONSTRAINT pkprecinto PRIMARY KEY (id),
  CONSTRAINT fk_precinto_medidores FOREIGN KEY (id_medidores)
      REFERENCES medidores (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class Precinto extends BaseModel{
    @Column
    @PrimaryKey
    int id;

    @Column
    int id_medidores; /** medidores (id)*/
    @Column
    String fch_cambio;
    @Column
    String pre_medidor_actual;
    @Column
    String pre_medidor_nuevo;

    @Column
    int version;
    @Column
    int accion;


    public Precinto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_medidores() {
        return id_medidores;
    }

    public void setId_medidores(int id_medidores) {
        this.id_medidores = id_medidores;
    }

    public String getFch_cambio() {
        return fch_cambio;
    }

    public void setFch_cambio(String fch_cambio) {
        this.fch_cambio = fch_cambio;
    }

    public String getPre_medidor_actual() {
        return pre_medidor_actual;
    }

    public void setPre_medidor_actual(String pre_medidor_actual) {
        this.pre_medidor_actual = pre_medidor_actual;
    }

    public String getPre_medidor_nuevo() {
        return pre_medidor_nuevo;
    }

    public void setPre_medidor_nuevo(String pre_medidor_nuevo) {
        this.pre_medidor_nuevo = pre_medidor_nuevo;
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
