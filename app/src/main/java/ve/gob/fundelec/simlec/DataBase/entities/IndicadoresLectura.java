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
CREATE TABLE indicadores_lectura
(
  id bigint NOT NULL DEFAULT nextval('indicadores_lectura_id_seq'::regclass),
  id_medidores bigint,
  id_programacion_calle bigint,
  cod_nota_lectura character varying(2),
  fch_lectura date,
  long_lat character varying(30),
  lim_super_kwh double precision,
  lim_infer_kwh double precision,
  lim_super_va double precision,
  lim_infer_va double precision,
  lectura_prevista double precision,
  consumo_kwh double precision,
  demanda_va double precision,
  version bigint,
  accion integer,
  fch_toma_lectura timestamp without time zone,
  CONSTRAINT pkindicadores_lectura PRIMARY KEY (id),
  CONSTRAINT fk_indicadores_lectura_medidores FOREIGN KEY (id_medidores)
      REFERENCES medidores (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_indicadores_lectura_programacion_calle FOREIGN KEY (id_programacion_calle)
      REFERENCES programacion_calle (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
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
    String fch_toma_lectura; // timestamp without time zone,

    @Column
    int version;
    @Column
    int accion;

    public IndicadoresLectura() {
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

    public int getId_programacion_calle() {
        return id_programacion_calle;
    }

    public void setId_programacion_calle(int id_programacion_calle) {
        this.id_programacion_calle = id_programacion_calle;
    }

    public String getCod_nota_lectura() {
        return cod_nota_lectura;
    }

    public void setCod_nota_lectura(String cod_nota_lectura) {
        this.cod_nota_lectura = cod_nota_lectura;
    }

    public String getFch_lectura() {
        return fch_lectura;
    }

    public void setFch_lectura(String fch_lectura) {
        this.fch_lectura = fch_lectura;
    }

    public String getLong_lat() {
        return long_lat;
    }

    public void setLong_lat(String long_lat) {
        this.long_lat = long_lat;
    }

    public double getLim_super_kwh() {
        return lim_super_kwh;
    }

    public void setLim_super_kwh(double lim_super_kwh) {
        this.lim_super_kwh = lim_super_kwh;
    }

    public double getLim_infer_kwh() {
        return lim_infer_kwh;
    }

    public void setLim_infer_kwh(double lim_infer_kwh) {
        this.lim_infer_kwh = lim_infer_kwh;
    }

    public double getLim_super_va() {
        return lim_super_va;
    }

    public void setLim_super_va(double lim_super_va) {
        this.lim_super_va = lim_super_va;
    }

    public double getLim_infer_va() {
        return lim_infer_va;
    }

    public void setLim_infer_va(double lim_infer_va) {
        this.lim_infer_va = lim_infer_va;
    }

    public double getLectura_prevista() {
        return lectura_prevista;
    }

    public void setLectura_prevista(double lectura_prevista) {
        this.lectura_prevista = lectura_prevista;
    }

    public double getConsumo_kwh() {
        return consumo_kwh;
    }

    public void setConsumo_kwh(double consumo_kwh) {
        this.consumo_kwh = consumo_kwh;
    }

    public double getDemanda_va() {
        return demanda_va;
    }

    public void setDemanda_va(double demanda_va) {
        this.demanda_va = demanda_va;
    }

    public String getFch_toma_lectura() {
        return fch_toma_lectura;
    }

    public void setFch_toma_lectura(String fch_toma_lectura) {
        this.fch_toma_lectura = fch_toma_lectura;
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
