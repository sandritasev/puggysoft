package com.puggysoft.repositories.projects;

import com.puggysoft.entities.projects.EntityProjectsPro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProjectsPro extends JpaRepository<EntityProjectsPro, Long> {

  @Query(value = "SELECT COUNT(*) FROM todo_projects;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM todo_projects LIMIT ?1, ?2", nativeQuery = true)
  List<EntityProjectsPro> findProjectsproByPagination(int off, int size);

}