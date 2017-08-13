package ve.gob.fundelec.simlec.ListMedidores.entities;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

import ve.gob.fundelec.simlec.DataBase.DataBaseSimlec;

/**
 * Created by fundelec on 07/08/17.
 */
@QueryModel(database = DataBaseSimlec.class)
public class QueryMedidores {


    @Column
    int id_medidor;
    @Column
    String long_lat; // limite de 30

    @Column
    int dig_entero;
    @Column
    int dig_decimal;
    @Column
    String modelo; //255
    @Column
    String numero; //255
    @Column
    String ubicacion;//255


    @Column
    int id_indicador_lectura;
    @Column
    int id_programacion_calle; // clave foranea programacion_calle (id)
    @Column
    int orden_lectura;
    @Column
    String cod_nota_lectura;    //2
    @Column
    int status_lectura;
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
    String fch_toma_lectura; // timestamp without time zone,
    @Column
    double consumo_kwh;
    @Column
    double demanda_va;

    public int getId_medidor() {
        return id_medidor;
    }

    public void setId_medidor(int id_medidor) {
        this.id_medidor = id_medidor;
    }

    public String getLong_lat() {
        return long_lat;
    }

    public void setLong_lat(String long_lat) {
        this.long_lat = long_lat;
    }

    public int getDig_entero() {
        return dig_entero;
    }

    public void setDig_entero(int dig_entero) {
        this.dig_entero = dig_entero;
    }

    public int getDig_decimal() {
        return dig_decimal;
    }

    public void setDig_decimal(int dig_decimal) {
        this.dig_decimal = dig_decimal;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId_indicador_lectura() {
        return id_indicador_lectura;
    }

    public void setId_indicador_lectura(int id_indicador_lectura) {
        this.id_indicador_lectura = id_indicador_lectura;
    }

    public int getId_programacion_calle() {
        return id_programacion_calle;
    }

    public void setId_programacion_calle(int id_programacion_calle) {
        this.id_programacion_calle = id_programacion_calle;
    }

    public int getOrden_lectura() {
        return orden_lectura;
    }

    public void setOrden_lectura(int orden_lectura) {
        this.orden_lectura = orden_lectura;
    }

    public String getCod_nota_lectura() {
        return cod_nota_lectura;
    }

    public void setCod_nota_lectura(String cod_nota_lectura) {
        this.cod_nota_lectura = cod_nota_lectura;
    }

    public int getStatus_lectura() {
        return status_lectura;
    }

    public void setStatus_lectura(int status_lectura) {
        this.status_lectura = status_lectura;
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

    public String getFch_toma_lectura() {
        return fch_toma_lectura;
    }

    public void setFch_toma_lectura(String fch_toma_lectura) {
        this.fch_toma_lectura = fch_toma_lectura;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
