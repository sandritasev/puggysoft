package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaCursosEstudiantes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaCursosEstudiantes extends JpaRepository<EntityEscuelaCursosEstudiantes, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_cursos_estudiantes;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_cursos_estudiantes LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaCursosEstudiantes> findEscuelaCursosEstudiantesByPagination(int off, int size);

}