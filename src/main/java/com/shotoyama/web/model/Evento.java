package com.shotoyama.web.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Evento {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank private String titulo;
    @Column(length=3000) private String descripcion;
    @NotNull @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") private LocalDateTime inicio;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") private LocalDateTime fin;
    private String ubicacion;
    private String tipo="CLUB";
    private boolean visible=true;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;}
    public String getDescripcion(){return descripcion;} public void setDescripcion(String v){descripcion=v;}
    public LocalDateTime getInicio(){return inicio;} public void setInicio(LocalDateTime v){inicio=v;}
    public LocalDateTime getFin(){return fin;} public void setFin(LocalDateTime v){fin=v;}
    public String getUbicacion(){return ubicacion;} public void setUbicacion(String v){ubicacion=v;}
    public String getTipo(){return tipo;} public void setTipo(String v){tipo=v;}
    public boolean isVisible(){return visible;} public void setVisible(boolean v){visible=v;}
}
