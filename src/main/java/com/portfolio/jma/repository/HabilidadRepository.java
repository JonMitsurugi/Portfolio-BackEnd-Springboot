package com.portfolio.jma.repository;

import com.portfolio.jma.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer>{
    public Optional<Habilidad> findByNombreHab(String nombreHab);
    public boolean existsByNombreHab(String nombreHab);
}
