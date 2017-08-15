package ve.gob.fundelec.simlec.DataBase.entities;

import com.google.gson.Gson;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 11/07/17.
 */
/**
CREATE TABLE objeto_conexion_notas
(
  id bigint NOT NULL DEFAULT nextval('objeto_conexion_notas_id_seq'::regclass),
  id_objeto_conexion bigint,
  fch_lectura timestamp without time zone NOT NULL,
  cod_nota_lectura character varying(2) NOT NULL,
  id_programacion_calle bigint NOT NULL,
  version bigint,
  accion integer,
  CONSTRAINT pkobjeto_conexion_notas PRIMARY KEY (id),
  CONSTRAINT fk_objeto_conexion_notas_objeto_conexion FOREIGN KEY (id_objeto_conexion)
      REFERENCES objeto_conexion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_objeto_conexion_notas_programacion_calle FOREIGN KEY (id_programacion_calle)
      REFERENCES programacion_calle (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class ObjetosConexionNotas extends BaseModel{
    @Column
    @PrimaryKey
    int id;
    @Column
    int id_objeto_conexion; /** objeto_conexion (id)*/
    @Column
    int id_programacion_calle; /** programacion_calle (id)*/
    @Column
    String fch_lectura; // timestamp without time zone NOT NULL
    @Column
    String cod_nota_lectura;
    @Column
    int version;
    @Column
    int accion;

    public ObjetosConexionNotas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_objeto_conexion() {
        return id_objeto_conexion;
    }

    public void setId_objeto_conexion(int id_objeto_conexion) {
        this.id_objeto_conexion = id_objeto_conexion;
    }

    public String getFch_lectura() {
        return fch_lectura;
    }

    public void setFch_lectura(Date fch_lectura) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.fch_lectura = sf.format(fch_lectura);
    }

    public String getCod_nota_lectura() {
        return cod_nota_lectura;
    }

    public void setCod_nota_lectura(String cod_nota_lectura) {
        this.cod_nota_lectura = cod_nota_lectura;
    }

    public int getId_programacion_calle() {
        return id_programacion_calle;
    }

    public void setId_programacion_calle(int id_programacion_calle) {
        this.id_programacion_calle = id_programacion_calle;
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

    @Override
    public String toString() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(this);
        return jsonString;
    }
}
