package com.shotoyama.web.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Noticia {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank @Size(max=180) private String titulo;
    @NotBlank @Size(max=420) @Column(length=420) private String resumen;
    @NotBlank @Column(length=12000) private String contenido;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) private LocalDate fechaPublicacion;
    private String imagenUrl;
    private String fuenteUrl;
    private boolean publicada=true;
    private boolean destacada;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;}
    public String getResumen(){return resumen;} public void setResumen(String v){resumen=v;}
    public String getContenido(){return contenido;} public void setContenido(String v){contenido=v;}
    public LocalDate getFechaPublicacion(){return fechaPublicacion;} public void setFechaPublicacion(LocalDate v){fechaPublicacion=v;}
    public String getImagenUrl(){return imagenUrl;} public void setImagenUrl(String v){imagenUrl=v;}
    public String getFuenteUrl(){return fuenteUrl;} public void setFuenteUrl(String v){fuenteUrl=v;}
    public boolean isPublicada(){return publicada;} public void setPublicada(boolean v){publicada=v;}
    public boolean isDestacada(){return destacada;} public void setDestacada(boolean v){destacada=v;}
}
