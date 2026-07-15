package com.shotoyama.web.repository;
import com.shotoyama.web.model.Horario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HorarioRepository extends JpaRepository<Horario,Long>{
    List<Horario> findByActivoTrueOrderByLocalidadAscOrdenVisualAsc();
}
