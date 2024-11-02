package com.web.bloggs.perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Perfil; 
    private String per_nombre;
    private String per_descripcion; 
    private String per_foto;
    private String per_portada;
    private Date per_fecha;

    public Long getID_Perfil() {
        return ID_Perfil;
    }

    public void setID_Perfil(Long ID_Perfil) {
        this.ID_Perfil = ID_Perfil;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_descripcion() {
        return per_descripcion;
    }

    public void setPer_descripcion(String per_descripcion) {
        this.per_descripcion = per_descripcion;
    }

    public String getPer_foto() {
        return per_foto;
    }

    public void setPer_foto(String per_foto) {
        this.per_foto = per_foto;
    }

    public String getPer_portada() {
        return per_portada;
    }

    public void setPer_portada(String per_portada) {
        this.per_portada = per_portada;
    }

    public Date getPer_fecha() {
        return per_fecha;
    }

    public void setPer_fecha(Date per_fecha) {
        this.per_fecha = per_fecha;
    }
    
}
