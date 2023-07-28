package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsProFilter;
import com.puggysoft.repositories.projects.IRepositoryProjectsPro;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.projects.SqlProjectsproFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceProjectsProGetFilterSize {

  @Autowired
  private IRepositoryProjectsPro repositoryProjectspro;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoProjectsProFilter dtoProjectsproFilter, Long pageSize) {

    String query = SqlProjectsproFilterBuilderNative.build(dtoProjectsproFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryProjectspro.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM todo_projects WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}