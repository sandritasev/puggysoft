package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTimeFilter;
import com.puggysoft.repositories.reservations.IRepositoryIntervalTime;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.reservations.SqlIntervalTimeFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceIntervalTimeGetFilterSize {

  @Autowired
  private IRepositoryIntervalTime repositoryIntervalTime;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoResIntervalTimeFilter dtoResIntervalTimeFilter, Long pageSize) {

    String query = SqlIntervalTimeFilterBuilderNative.build(dtoResIntervalTimeFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryIntervalTime.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM res_interval_time WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
