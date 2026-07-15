package com.shotoyama.web.controller;
import com.shotoyama.web.model.Evento;
import com.shotoyama.web.repository.EventoRepository;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/eventos")
public class ApiEventoController {
 private final EventoRepository repository;
 private static final DateTimeFormatter G=DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
 public ApiEventoController(EventoRepository r){repository=r;}
 @GetMapping public List<EventoDto> listar(){return repository.findByVisibleTrueOrderByInicioAsc().stream().map(this::dto).toList();}
 private EventoDto dto(Evento e){
  var fin=e.getFin()==null?e.getInicio().plusHours(2):e.getFin();
  String url="https://calendar.google.com/calendar/render?action=TEMPLATE&text="+enc(e.getTitulo())+"&dates="+e.getInicio().format(G)+"/"+fin.format(G)+"&details="+enc(e.getDescripcion())+"&location="+enc(e.getUbicacion());
  return new EventoDto(e.getId(),e.getTitulo(),e.getDescripcion(),e.getInicio().toString(),fin.toString(),e.getUbicacion(),e.getTipo(),url);
 }
 private String enc(String v){return URLEncoder.encode(v==null?"":v,StandardCharsets.UTF_8);}
 public record EventoDto(Long id,String titulo,String descripcion,String inicio,String fin,String ubicacion,String tipo,String googleCalendarUrl){}
}
