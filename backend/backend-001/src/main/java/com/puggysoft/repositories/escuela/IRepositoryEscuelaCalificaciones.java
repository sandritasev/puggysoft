package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaCalificaciones;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaCalificaciones extends JpaRepository<EntityEscuelaCalificaciones, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_calificaciones;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_calificaciones LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaCalificaciones> findEscuelaCalificacionesByPagination(int off, int size);

}