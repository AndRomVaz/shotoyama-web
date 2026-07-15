package com.shotoyama.web.repository;
import com.shotoyama.web.model.MensajeContacto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MensajeContactoRepository extends JpaRepository<MensajeContacto,Long>{
    List<MensajeContacto> findAllByOrderByFechaEnvioDesc();
    long countByLeidoFalse();
}
