package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaNotas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaNotas extends JpaRepository<EntityEscuelaNotas, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_notas;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_notas LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaNotas> findEscuelaNotasByPagination(int off, int size);

}