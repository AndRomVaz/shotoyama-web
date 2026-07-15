package com.shotoyama.web.repository;
import com.shotoyama.web.model.Actividad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActividadRepository extends JpaRepository<Actividad,Long>{
    List<Actividad> findByActivaTrueOrderByOrdenVisualAscNombreAsc();
}
