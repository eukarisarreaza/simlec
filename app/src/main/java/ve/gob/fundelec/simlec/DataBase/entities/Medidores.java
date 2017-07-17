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
public class Medidores extends BaseModel {
    @Column
    @PrimaryKey
    int id;
    @Column
    int id_objeto_conexion; // clave foranea objeto_conexion (id)
    @Column
    int tip_medidor;
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
    String contrato; //255
    @Column
    String pre_medidor; //limite de 20
    @Column
    int edo_medidor;
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

    public int getId_objeto_conexion() {
        return id_objeto_conexion;
    }

    public void setId_objeto_conexion(int id_objeto_conexion) {
        this.id_objeto_conexion = id_objeto_conexion;
    }

    public int getTip_medidor() {
        return tip_medidor;
    }

    public void setTip_medidor(int tip_medidor) {
        this.tip_medidor = tip_medidor;
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

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getPre_medidor() {
        return pre_medidor;
    }

    public void setPre_medidor(String pre_medidor) {
        this.pre_medidor = pre_medidor;
    }

    public int getEdo_medidor() {
        return edo_medidor;
    }

    public void setEdo_medidor(int edo_medidor) {
        this.edo_medidor = edo_medidor;
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
