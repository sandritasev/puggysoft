package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResBookingFilter;
import com.puggysoft.repositories.reservations.IRepositoryBooking;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.reservations.SqlBookingFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceBookingGetFilterSize {

  @Autowired
  private IRepositoryBooking repositoryBooking;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoResBookingFilter dtoResBookingFilter, Long pageSize) {

    String query = SqlBookingFilterBuilderNative.build(dtoResBookingFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryBooking.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM res_booking WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
