package com.shotoyama.web.controller;
import com.shotoyama.web.model.MensajeContacto;
import com.shotoyama.web.repository.*;
import jakarta.validation.Valid;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class PublicController {
 private final NoticiaRepository noticias; private final EventoRepository eventos;
 private final ActividadRepository actividades; private final HorarioRepository horarios;
 private final MensajeContactoRepository mensajes;
 @Value("${app.google-calendar.embed-url:}") private String googleCalendar;
 public PublicController(NoticiaRepository n,EventoRepository e,ActividadRepository a,HorarioRepository h,MensajeContactoRepository m){
  noticias=n;eventos=e;actividades=a;horarios=h;mensajes=m;
 }
 @GetMapping("/") String inicio(Model m){
  m.addAttribute("pagina","inicio");
  m.addAttribute("noticias",noticias.findTop3ByPublicadaTrueOrderByFechaPublicacionDesc());
  m.addAttribute("eventos",eventos.findTop5ByVisibleTrueAndInicioGreaterThanEqualOrderByInicioAsc(LocalDateTime.now().minusHours(2)));
  return "public/inicio";
 }
 @GetMapping("/calendario") String calendario(Model m){
  m.addAttribute("pagina","calendario");
  m.addAttribute("eventos",eventos.findTop5ByVisibleTrueAndInicioGreaterThanEqualOrderByInicioAsc(LocalDateTime.now().minusHours(2)));
  m.addAttribute("googleCalendar",googleCalendar);
  return "public/calendario";
 }
 @GetMapping("/horarios") String horarios(Model m){
  Map<String,List<com.shotoyama.web.model.Horario>> grupos=horarios.findByActivoTrueOrderByLocalidadAscOrdenVisualAsc().stream()
   .collect(Collectors.groupingBy(com.shotoyama.web.model.Horario::getLocalidad,LinkedHashMap::new,Collectors.toList()));
  m.addAttribute("pagina","horarios");m.addAttribute("grupos",grupos);return "public/horarios";
 }
 @GetMapping("/actividades") String actividades(Model m){m.addAttribute("pagina","actividades");m.addAttribute("actividades",actividades.findByActivaTrueOrderByOrdenVisualAscNombreAsc());return "public/actividades";}
 @GetMapping("/noticias") String noticias(Model m){m.addAttribute("pagina","noticias");m.addAttribute("noticias",noticias.findByPublicadaTrueOrderByFechaPublicacionDesc());return "public/noticias";}
 @GetMapping("/noticias/{id}") String noticia(@PathVariable Long id,Model m){m.addAttribute("pagina","noticias");m.addAttribute("noticia",noticias.findById(id).orElseThrow());return "public/noticia";}
 @GetMapping("/contacto") String contacto(Model m){m.addAttribute("pagina","contacto");if(!m.containsAttribute("mensajeContacto"))m.addAttribute("mensajeContacto",new MensajeContacto());return "public/contacto";}
 @PostMapping("/contacto") String contactoPost(@Valid MensajeContacto mensajeContacto,BindingResult r,Model m,RedirectAttributes ra){
  if(r.hasErrors()){m.addAttribute("pagina","contacto");return "public/contacto";}
  mensajeContacto.setFechaEnvio(LocalDateTime.now());mensajes.save(mensajeContacto);
  ra.addFlashAttribute("exito","Mensaje enviado correctamente. El club contactará contigo lo antes posible.");
  return "redirect:/contacto";
 }
}
