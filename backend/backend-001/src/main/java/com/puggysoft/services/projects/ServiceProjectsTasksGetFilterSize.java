package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasksFilter;
import com.puggysoft.repositories.projects.IRepositoryProjectsTasks;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.projects.SqlProjectstasksFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceProjectsTasksGetFilterSize {

  @Autowired
  private IRepositoryProjectsTasks repositoryProjectstasks;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoProjectsTasksFilter dtoProjectstasksFilter, Long pageSize) {

    String query = SqlProjectstasksFilterBuilderNative.build(dtoProjectstasksFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryProjectstasks.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM todo_tasks WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}