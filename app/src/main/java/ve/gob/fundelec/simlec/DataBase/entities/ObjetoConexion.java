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
CREATE TABLE objeto_conexion
(
  id bigint NOT NULL DEFAULT nextval('objeto_conexion_id_seq'::regclass),
  id_calle_avenida bigint,
  cod_obj_conex bigint NOT NULL,
  nom_obj_conex character varying(100) NOT NULL,
  ord_obj_conex bigint NOT NULL,
  interlocutor character varying(255),
  apendice character varying(20),
  piso character varying(8),
  nro_habitacion character varying(10),
  emplazamiento character varying(10),
  version bigint,
  accion integer,
  CONSTRAINT pkobjeto_conexion PRIMARY KEY (id),
  CONSTRAINT fk_objeto_conexion_calle_avenida FOREIGN KEY (id_calle_avenida)
      REFERENCES calle_avenida (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 */
@Table(database = DataBaseSimlec.class)
public class ObjetoConexion extends BaseModel{
    @Column
    @PrimaryKey
    int id;
    @Column
    int id_calle_avenida; // clave foranea  calle_avenida (id)
    @Column
    String cod_obj_conex;
    @Column
    String nom_obj_conex;//100
    @Column
    int ord_obj_conex;
    @Column
    String interlocutor;//255
    @Column
    String apendice;//20
    @Column
    String piso;//8
    @Column
    String nro_habitacion;//10
    @Column
    String emplazamiento;//10

    @Column
    int version;
    @Column
    int accion;

    public ObjetoConexion() {
    }

    public ObjetoConexion(int id, int id_calle_avenida, String cod_obj_conex, String nom_obj_conex,
                          int ord_obj_conex, String interlocutor, String apendice, String piso, String nro_habitacion, String emplazamiento, int version, int accion) {
        this.id = id;
        this.id_calle_avenida = id_calle_avenida;
        this.cod_obj_conex = cod_obj_conex;
        this.nom_obj_conex = nom_obj_conex;
        this.ord_obj_conex = ord_obj_conex;
        this.interlocutor = interlocutor;
        this.apendice = apendice;
        this.piso = piso;
        this.nro_habitacion = nro_habitacion;
        this.emplazamiento = emplazamiento;
        this.version = version;
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_calle_avenida() {
        return id_calle_avenida;
    }

    public void setId_calle_avenida(int id_calle_avenida) {
        this.id_calle_avenida = id_calle_avenida;
    }


    public String getCod_obj_conex() {
        return cod_obj_conex;
    }

    public void setCod_obj_conex(String cod_obj_conex) {
        this.cod_obj_conex = cod_obj_conex;
    }

    public String getNom_obj_conex() {
        return nom_obj_conex;
    }

    public void setNom_obj_conex(String nom_obj_conex) {
        this.nom_obj_conex = nom_obj_conex;
    }

    public int getOrd_obj_conex() {
        return ord_obj_conex;
    }

    public void setOrd_obj_conex(int ord_obj_conex) {
        this.ord_obj_conex = ord_obj_conex;
    }

    public String getInterlocutor() {
        return interlocutor;
    }

    public void setInterlocutor(String interlocutor) {
        this.interlocutor = interlocutor;
    }

    public String getApendice() {
        return apendice;
    }

    public void setApendice(String apendice) {
        this.apendice = apendice;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNro_habitacion() {
        return nro_habitacion;
    }

    public void setNro_habitacion(String nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }

    public String getEmplazamiento() {
        return emplazamiento;
    }

    public void setEmplazamiento(String emplazamiento) {
        this.emplazamiento = emplazamiento;
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
