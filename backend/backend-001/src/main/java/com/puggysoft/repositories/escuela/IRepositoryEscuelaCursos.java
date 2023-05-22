package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaCursos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaCursos extends JpaRepository<EntityEscuelaCursos, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_cursos;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_cursos LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaCursos> findEscuelaCursosByPagination(int off, int size);

}