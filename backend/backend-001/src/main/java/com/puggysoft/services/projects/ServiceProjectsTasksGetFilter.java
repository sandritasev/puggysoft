package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.dtos.projects.DtoProjectsTasksFilter;
import com.puggysoft.entities.projects.EntityProjectsTasks;
import com.puggysoft.repositories.projects.IRepositoryProjectsTasks;
import com.puggysoft.tools.projects.SqlProjectstasksFilterBuilderNative;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for filter. */
@Service
public class ServiceProjectsTasksGetFilter {

  @Autowired
  private IRepositoryProjectsTasks repositoryProjectstasks;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  public ResponseEntity<List<DtoProjectsTasks>> filter(DtoProjectsTasksFilter dtoProjectstasksFilter, int page,
      int size) {

    String query = SqlProjectstasksFilterBuilderNative.build(dtoProjectstasksFilter);
    int off = page * size;
    List<EntityProjectsTasks> listEntities;
    if (query.equals("")) {
      listEntities = repositoryProjectstasks.findProjectstasksByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT todo_tasks.* FROM todo_tasks WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityProjectsTasks.class);
      listEntities = (List<EntityProjectsTasks>) filterQuery.getResultList();

    }
    List<DtoProjectsTasks> listDtoProjectstasks = listEntities
        .stream()
        .map(DtoProjectsTasks::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoProjectstasks);
  }

}
