package com.shotoyama.web.repository;
import com.shotoyama.web.model.Evento;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventoRepository extends JpaRepository<Evento,Long>{
    List<Evento> findByVisibleTrueOrderByInicioAsc();
    List<Evento> findTop5ByVisibleTrueAndInicioGreaterThanEqualOrderByInicioAsc(LocalDateTime desde);
}
