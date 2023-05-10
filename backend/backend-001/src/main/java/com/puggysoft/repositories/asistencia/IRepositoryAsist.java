package com.puggysoft.repositories.asistencia;

import com.puggysoft.entities.asistencia.EntityAsist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryAsist extends JpaRepository<EntityAsist, Long> {

  @Query(value = "SELECT COUNT(*) FROM asistencia_control;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM asistencia_control LIMIT ?1, ?2", nativeQuery = true)
  List<EntityAsist> findAsistByPagination(int off, int size);

}
