package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceFilter;
import com.puggysoft.repositories.reservations.IRepositoryResource;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.reservations.SqlResourceFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceResourceGetFilterSize {

  @Autowired
  private IRepositoryResource repositoryResource;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoResResourceFilter dtoResResourceFilter, Long pageSize) {

    String query = SqlResourceFilterBuilderNative.build(dtoResResourceFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryResource.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM res_resources WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
