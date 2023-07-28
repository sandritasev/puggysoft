package com.puggysoft.repositories.projects;

import com.puggysoft.entities.projects.EntityProjectsStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProjectsStatus extends JpaRepository<EntityProjectsStatus, Long> {

  @Query(value = "SELECT COUNT(*) FROM todo_status;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM todo_status LIMIT ?1, ?2", nativeQuery = true)
  List<EntityProjectsStatus> findProjectsstatusByPagination(int off, int size);

}