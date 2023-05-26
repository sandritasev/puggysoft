package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleIntervalTimeFilter;
import com.puggysoft.repositories.reservations.IRepositoryScheduleIntervalTime;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.reservations.SqlScheduleIntervalTimeFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceScheduleIntervalTimeGetFilterSize {

  @Autowired
  private IRepositoryScheduleIntervalTime repositoryScheduleIntervalTime;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoResScheduleIntervalTimeFilter dtoResScheduleIntervalTimeFilter,
      Long pageSize) {

    String query = SqlScheduleIntervalTimeFilterBuilderNative.build(dtoResScheduleIntervalTimeFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryScheduleIntervalTime.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM res_schedule_interval_time WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
