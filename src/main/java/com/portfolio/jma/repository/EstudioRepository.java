package com.portfolio.jma.repository;

import com.portfolio.jma.model.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Integer>{
    public Optional<Estudio> findByNombreEst(String nombreEst);
    public boolean existsByNombreEst(String nombreEst);
}
