package com.shotoyama.web.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
@Entity
public class MensajeContacto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank private String nombre;
    @NotBlank @Email private String email;
    private String telefono;
    @NotBlank private String asunto;
    @NotBlank @Size(max=3000) @Column(length=3000) private String mensaje;
    private LocalDateTime fechaEnvio;
    private boolean leido;
    public Long getId(){return id;} public void setId(Long v){id=v;}
    public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getTelefono(){return telefono;} public void setTelefono(String v){telefono=v;}
    public String getAsunto(){return asunto;} public void setAsunto(String v){asunto=v;}
    public String getMensaje(){return mensaje;} public void setMensaje(String v){mensaje=v;}
    public LocalDateTime getFechaEnvio(){return fechaEnvio;} public void setFechaEnvio(LocalDateTime v){fechaEnvio=v;}
    public boolean isLeido(){return leido;} public void setLeido(boolean v){leido=v;}
}
