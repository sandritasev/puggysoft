package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaNotasMaterias;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaNotasMaterias extends JpaRepository<EntityEscuelaNotasMaterias, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_notas_materias;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_notas_materias LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaNotasMaterias> findEscuelaNotasMateriasByPagination(int off, int size);

}