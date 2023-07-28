package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatusFilter;
import com.puggysoft.repositories.projects.IRepositoryProjectsStatus;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.projects.SqlProjectsstatusFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceProjectsStatusGetFilterSize {

  @Autowired
  private IRepositoryProjectsStatus repositoryProjectsstatus;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoProjectsStatusFilter dtoProjectsstatusFilter, Long pageSize) {

    String query = SqlProjectsstatusFilterBuilderNative.build(dtoProjectsstatusFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryProjectsstatus.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM todo_status WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}