package com.shotoyama.web.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
public class Actividad {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank private String nombre;
    @NotBlank @Column(length=500) private String resumen;
    @NotBlank @Column(length=6000) private String descripcion;
    private String categoria;
    private String edad;
    private String imagenUrl;
    private int ordenVisual;
    private boolean activa=true;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
    public String getResumen(){return resumen;} public void setResumen(String v){resumen=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public String getCategoria(){return categoria;} public void setCategoria(String v){categoria=v;}
    public String getEdad(){return edad;} public void setEdad(String v){edad=v;}
    public String getImagenUrl(){return imagenUrl;} public void setImagenUrl(String v){imagenUrl=v;}
    public int getOrdenVisual(){return ordenVisual;} public void setOrdenVisual(int v){ordenVisual=v;}
    public boolean isActiva(){return activa;} public void setActiva(boolean v){activa=v;}
}
