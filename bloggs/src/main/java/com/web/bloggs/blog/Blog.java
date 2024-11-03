package com.web.bloggs.blog;

import com.web.bloggs.perfil.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Blog;
    private String blo_titulo;
    private String blo_categoria;
    private Date blo_fecha;
    private String blo_contenido;

    @OneToOne
    @JoinColumn(name = "ID_Perfil")
    private Perfil ID_Perfil;

    public Long getID_Blog() {
        return ID_Blog;
    }

    public void setID_Blog(Long ID_Blog) {
        this.ID_Blog = ID_Blog;
    }

    public String getBlo_titulo() {
        return blo_titulo;
    }

    public void setBlo_titulo(String blo_titulo) {
        this.blo_titulo = blo_titulo;
    }

    public String getBlo_categoria() {
        return blo_categoria;
    }

    public void setBlo_categoria(String blo_categoria) {
        this.blo_categoria = blo_categoria;
    }

    public Date getBlo_fecha() {
        return blo_fecha;
    }

    public void setBlo_fecha(Date blo_fecha) {
        this.blo_fecha = blo_fecha;
    }

    public String getBlo_contenido() {
        return blo_contenido;
    }

    public void setBlo_contenido(String blo_contenido) {
        this.blo_contenido = blo_contenido;
    }

    public Perfil getID_Perfil() {
        return ID_Perfil;
    }

    public void setID_Perfil(Perfil ID_Perfil) {
        this.ID_Perfil = ID_Perfil;
    }

}
