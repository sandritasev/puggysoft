package com.puggysoft.repositories.projects;

import com.puggysoft.entities.projects.EntityProjectsTasks;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProjectsTasks extends JpaRepository<EntityProjectsTasks, Long> {

  @Query(value = "SELECT COUNT(*) FROM todo_tasks;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM todo_tasks LIMIT ?1, ?2", nativeQuery = true)
  List<EntityProjectsTasks> findProjectstasksByPagination(int off, int size);

}