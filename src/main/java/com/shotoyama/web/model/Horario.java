package com.shotoyama.web.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
public class Horario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank private String localidad;
    @NotBlank private String grupo;
    @NotBlank private String dias;
    @NotBlank private String franja;
    private String instalacion;
    private String entrenador;
    private String observaciones;
    private int ordenVisual;
    private boolean activo=true;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getLocalidad(){return localidad;} public void setLocalidad(String v){localidad=v;}
    public String getGrupo(){return grupo;} public void setGrupo(String v){grupo=v;}
    public String getDias(){return dias;} public void setDias(String v){dias=v;}
    public String getFranja(){return franja;} public void setFranja(String v){franja=v;}
    public String getInstalacion(){return instalacion;} public void setInstalacion(String v){instalacion=v;}
    public String getEntrenador(){return entrenador;} public void setEntrenador(String v){entrenador=v;}
    public String getObservaciones(){return observaciones;} public void setObservaciones(String v){observaciones=v;}
    public int getOrdenVisual(){return ordenVisual;} public void setOrdenVisual(int v){ordenVisual=v;}
    public boolean isActivo(){return activo;} public void setActivo(boolean v){activo=v;}
}
