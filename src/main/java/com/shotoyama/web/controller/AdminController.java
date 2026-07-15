package com.shotoyama.web.controller;
import com.shotoyama.web.model.*;
import com.shotoyama.web.repository.*;
import jakarta.validation.Valid;
import java.time.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/admin")
public class AdminController {
 private final NoticiaRepository noticias; private final EventoRepository eventos;
 private final ActividadRepository actividades; private final HorarioRepository horarios;
 private final MensajeContactoRepository mensajes;
 public AdminController(NoticiaRepository n,EventoRepository e,ActividadRepository a,HorarioRepository h,MensajeContactoRepository m){noticias=n;eventos=e;actividades=a;horarios=h;mensajes=m;}
 @GetMapping("/login") String login(){return "admin/login";}
 @GetMapping({"","/"}) String panel(Model m){
  m.addAttribute("noticias",noticias.count());m.addAttribute("eventos",eventos.count());m.addAttribute("actividades",actividades.count());m.addAttribute("horarios",horarios.count());m.addAttribute("mensajes",mensajes.countByLeidoFalse());
  m.addAttribute("proximos",eventos.findTop5ByVisibleTrueAndInicioGreaterThanEqualOrderByInicioAsc(LocalDateTime.now().minusHours(2)));return "admin/panel";
 }
 @GetMapping("/noticias") String noticias(Model m){m.addAttribute("elementos",noticias.findAll());return "admin/noticias";}
 @GetMapping("/noticias/nueva") String nuevaNoticia(Model m){m.addAttribute("noticia",new Noticia());return "admin/noticia-form";}
 @GetMapping("/noticias/{id}/editar") String editarNoticia(@PathVariable Long id,Model m){m.addAttribute("noticia",noticias.findById(id).orElseThrow());return "admin/noticia-form";}
 @PostMapping("/noticias/guardar") String guardarNoticia(@Valid Noticia n,BindingResult r,RedirectAttributes ra){
  if(r.hasErrors())return "admin/noticia-form";if(n.getFechaPublicacion()==null)n.setFechaPublicacion(LocalDate.now());noticias.save(n);ra.addFlashAttribute("exito","Noticia guardada.");return "redirect:/admin/noticias";
 }
 @PostMapping("/noticias/{id}/eliminar") String eliminarNoticia(@PathVariable Long id,RedirectAttributes ra){noticias.deleteById(id);ra.addFlashAttribute("exito","Noticia eliminada.");return "redirect:/admin/noticias";}
 @GetMapping("/eventos") String eventos(Model m){m.addAttribute("elementos",eventos.findAll());return "admin/eventos";}
 @GetMapping("/eventos/nuevo") String nuevoEvento(Model m){m.addAttribute("evento",new Evento());return "admin/evento-form";}
 @GetMapping("/eventos/{id}/editar") String editarEvento(@PathVariable Long id,Model m){m.addAttribute("evento",eventos.findById(id).orElseThrow());return "admin/evento-form";}
 @PostMapping("/eventos/guardar") String guardarEvento(@Valid Evento e,BindingResult r,RedirectAttributes ra){
  if(r.hasErrors())return "admin/evento-form";if(e.getFin()==null)e.setFin(e.getInicio().plusHours(2));eventos.save(e);ra.addFlashAttribute("exito","Evento guardado.");return "redirect:/admin/eventos";
 }
 @PostMapping("/eventos/{id}/eliminar") String eliminarEvento(@PathVariable Long id,RedirectAttributes ra){eventos.deleteById(id);ra.addFlashAttribute("exito","Evento eliminado.");return "redirect:/admin/eventos";}
 @GetMapping("/actividades") String actividades(Model m){m.addAttribute("elementos",actividades.findAll());return "admin/actividades";}
 @GetMapping("/actividades/nueva") String nuevaActividad(Model m){m.addAttribute("actividad",new Actividad());return "admin/actividad-form";}
 @GetMapping("/actividades/{id}/editar") String editarActividad(@PathVariable Long id,Model m){m.addAttribute("actividad",actividades.findById(id).orElseThrow());return "admin/actividad-form";}
 @PostMapping("/actividades/guardar") String guardarActividad(@Valid Actividad a,BindingResult r,RedirectAttributes ra){if(r.hasErrors())return "admin/actividad-form";actividades.save(a);ra.addFlashAttribute("exito","Actividad guardada.");return "redirect:/admin/actividades";}
 @PostMapping("/actividades/{id}/eliminar") String eliminarActividad(@PathVariable Long id,RedirectAttributes ra){actividades.deleteById(id);ra.addFlashAttribute("exito","Actividad eliminada.");return "redirect:/admin/actividades";}
 @GetMapping("/horarios") String horarios(Model m){m.addAttribute("elementos",horarios.findAll());return "admin/horarios";}
 @GetMapping("/horarios/nuevo") String nuevoHorario(Model m){m.addAttribute("horario",new Horario());return "admin/horario-form";}
 @GetMapping("/horarios/{id}/editar") String editarHorario(@PathVariable Long id,Model m){m.addAttribute("horario",horarios.findById(id).orElseThrow());return "admin/horario-form";}
 @PostMapping("/horarios/guardar") String guardarHorario(@Valid Horario h,BindingResult r,RedirectAttributes ra){if(r.hasErrors())return "admin/horario-form";horarios.save(h);ra.addFlashAttribute("exito","Horario guardado.");return "redirect:/admin/horarios";}
 @PostMapping("/horarios/{id}/eliminar") String eliminarHorario(@PathVariable Long id,RedirectAttributes ra){horarios.deleteById(id);ra.addFlashAttribute("exito","Horario eliminado.");return "redirect:/admin/horarios";}
 @GetMapping("/mensajes") String mensajes(Model m){m.addAttribute("elementos",mensajes.findAllByOrderByFechaEnvioDesc());return "admin/mensajes";}
 @GetMapping("/mensajes/{id}") String mensaje(@PathVariable Long id,Model m){MensajeContacto x=mensajes.findById(id).orElseThrow();x.setLeido(true);mensajes.save(x);m.addAttribute("mensaje",x);return "admin/mensaje";}
 @PostMapping("/mensajes/{id}/eliminar") String eliminarMensaje(@PathVariable Long id,RedirectAttributes ra){mensajes.deleteById(id);ra.addFlashAttribute("exito","Mensaje eliminado.");return "redirect:/admin/mensajes";}
}
