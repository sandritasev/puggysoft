package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaCursosMaterias;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaCursosMaterias extends JpaRepository<EntityEscuelaCursosMaterias, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_cursos_materias;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_cursos_materias LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaCursosMaterias> findEscuelaCursosMateriasByPagination(int off, int size);

}