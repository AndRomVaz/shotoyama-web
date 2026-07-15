package com.shotoyama.web.repository;
import com.shotoyama.web.model.Noticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NoticiaRepository extends JpaRepository<Noticia,Long>{
    List<Noticia> findByPublicadaTrueOrderByFechaPublicacionDesc();
    List<Noticia> findTop3ByPublicadaTrueOrderByFechaPublicacionDesc();
}
