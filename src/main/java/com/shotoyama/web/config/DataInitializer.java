package com.shotoyama.web.config;
import com.shotoyama.web.model.*;
import com.shotoyama.web.repository.*;
import java.time.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner seed(NoticiaRepository nr,EventoRepository er,ActividadRepository ar,HorarioRepository hr){
  return args->{
   if(nr.count()==0){
    nr.save(n("El Shotoyama cosecha 17 medallas en el Trofeo de Andalucía","La expedición firmó una gran actuación en Antequera, con ocho platas y nueve bronces.","El Club Deportivo Shotoyama volvió a demostrar el trabajo de su cantera en el Trofeo de Andalucía. La expedición consiguió 17 medallas y sumó experiencia competitiva en kata y kumite.\n\nEsta noticia es contenido inicial de demostración y puede editarse desde el panel.",LocalDate.of(2026,6,23),"https://marchenasecreta.com/el-shotoyama-cosecha-17-medallas-en-el-trofeo-de-andalucia/"));
    nr.save(n("Mercedes e Isabella Luna, campeonas de España por equipos","Las deportistas del club revalidaron el título nacional.","Mercedes e Isabella Luna Macho se proclamaron campeonas de España por equipos. El resultado premia la constancia de las deportistas, sus familias y el equipo técnico.",LocalDate.of(2026,6,22),"https://cadenaser.com/andalucia/2026/06/22/doble-oro-nacional-en-karate-para-las-hermanas-luna-macho-en-el-campeonato-de-espana-cadena-ser/"));
    nr.save(n("Carmen Cruz logra el bronce nacional en kata","La joven karateka subió al podio del Campeonato de España Infantil.","Carmen Cruz Jaramillo consiguió la medalla de bronce en kata en el Campeonato de España Infantil celebrado en Oviedo.",LocalDate.of(2026,5,10),""));
   }
   if(ar.count()==0){
    ar.save(a("Karate infantil","Iniciación mediante juegos, coordinación y valores.","Clases adaptadas a las primeras etapas, con psicomotricidad, respeto, concentración y fundamentos técnicos.","Formación","Desde 4 años",1));
    ar.save(a("Karate de competición","Preparación específica de kata y kumite.","Entrenamiento técnico, táctico y físico dirigido a competiciones provinciales, autonómicas y nacionales.","Competición","Según nivel",2));
    ar.save(a("Karate para adultos","Actividad completa para mejorar forma física y confianza.","Programa progresivo para personas adultas, tanto principiantes como practicantes con experiencia.","Salud","Adultos",3));
    ar.save(a("Defensa personal femenina","Talleres prácticos de prevención y autoprotección.","Sesiones para adquirir recursos básicos de autoprotección en un ambiente seguro y accesible.","Taller","Desde 16 años",4));
   }
   if(hr.count()==0){
    hr.save(h("Marchena","Grupo infantil","Lunes y miércoles","17:00 - 18:00",1));
    hr.save(h("Marchena","Grupo avanzado","Lunes y miércoles","18:00 - 19:30",2));
    hr.save(h("Morón de la Frontera","Karate base","Martes y jueves","17:30 - 18:30",1));
    hr.save(h("El Coronil","Grupo general","Martes y jueves","18:00 - 19:00",1));
    hr.save(h("La Puebla de Cazalla","Grupo general","Viernes","17:00 - 19:00",1));
   }
   if(er.count()==0){
    LocalDate d=LocalDate.now();
    er.save(e("Entrenamiento conjunto de verano","Sesión abierta para los grupos del club.",d.plusDays(2).atTime(18,0),d.plusDays(2).atTime(20,0),"Marchena","ENTRENAMIENTO"));
    er.save(e("Jornada técnica de kata","Trabajo específico de kata de competición.",d.plusDays(9).atTime(10,0),d.plusDays(9).atTime(13,0),"Morón de la Frontera","TECNIFICACIÓN"));
    er.save(e("Reunión informativa de familias","Presentación del calendario de la nueva temporada.",d.plusDays(16).atTime(19,0),d.plusDays(16).atTime(20,0),"Sede del club","CLUB"));
   }
  };
 }
 private Noticia n(String t,String r,String c,LocalDate f,String s){Noticia n=new Noticia();n.setTitulo(t);n.setResumen(r);n.setContenido(c);n.setFechaPublicacion(f);n.setFuenteUrl(s);return n;}
 private Actividad a(String n,String r,String d,String c,String e,int o){Actividad a=new Actividad();a.setNombre(n);a.setResumen(r);a.setDescripcion(d);a.setCategoria(c);a.setEdad(e);a.setOrdenVisual(o);return a;}
 private Horario h(String l,String g,String d,String f,int o){Horario h=new Horario();h.setLocalidad(l);h.setGrupo(g);h.setDias(d);h.setFranja(f);h.setInstalacion("Instalación por confirmar");h.setEntrenador("Equipo técnico Shotoyama");h.setOrdenVisual(o);return h;}
 private Evento e(String t,String d,LocalDateTime i,LocalDateTime f,String u,String tipo){Evento e=new Evento();e.setTitulo(t);e.setDescripcion(d);e.setInicio(i);e.setFin(f);e.setUbicacion(u);e.setTipo(tipo);return e;}
}
