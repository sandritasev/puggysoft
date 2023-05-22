package com.puggysoft.repositories.escuela;

import com.puggysoft.entities.escuela.EntityEscuelaMaterias;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryEscuelaMaterias extends JpaRepository<EntityEscuelaMaterias, Long> {

  @Query(value = "SELECT COUNT(*) FROM escuela_materias;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM escuela_materias LIMIT ?1, ?2", nativeQuery = true)
  List<EntityEscuelaMaterias> findEscuelaMateriasByPagination(int off, int size);

}