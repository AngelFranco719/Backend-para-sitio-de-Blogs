package com.web.bloggs.blog;
import com.fasterxml.jackson.databind.JsonNode;
import com.web.bloggs.perfil.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType; 
import com.web.bloggs.converters.JsonNodeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Blog;
    private String blo_titulo;
    private String blo_categoria;
    private Date blo_fecha;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode blo_contenido;

    @OneToOne
    @JoinColumn(name = "ID_Perfil", nullable = false)
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

    public JsonNode getBlo_contenido() {
        return this.blo_contenido;
    }

    public void setBlo_contenido(JsonNode blo_contenido) {
        this.blo_contenido = blo_contenido;
    }

    public Perfil getID_Perfil() {
        return ID_Perfil;
    }

    public void setID_Perfil(Perfil ID_Perfil) {
        this.ID_Perfil = ID_Perfil;
    }

}
