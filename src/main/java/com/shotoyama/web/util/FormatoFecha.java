package com.shotoyama.web.util;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.springframework.stereotype.Component;
@Component("formato")
public class FormatoFecha {
    private static final Locale ES=Locale.forLanguageTag("es-ES");
    public String fecha(LocalDate v){return v==null?"":v.format(DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy",ES));}
    public String corta(LocalDate v){return v==null?"":v.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));}
    public String diaMes(LocalDateTime v){return v==null?"":v.format(DateTimeFormatter.ofPattern("d MMM",ES));}
    public String hora(LocalDateTime v){return v==null?"":v.format(DateTimeFormatter.ofPattern("HH:mm"));}
    public String fechaHora(LocalDateTime v){return v==null?"":v.format(DateTimeFormatter.ofPattern("d MMM yyyy · HH:mm",ES));}
}
