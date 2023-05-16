package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResBooking;
import com.puggysoft.dtos.reservations.DtoResBookingFilter;
import com.puggysoft.entities.reservations.EntityResBooking;
import com.puggysoft.repositories.reservations.IRepositoryBooking;
import com.puggysoft.tools.reservations.SqlBookingFilterBuilderNative;
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
public class ServiceBookingGetFilter {

  @Autowired
  private IRepositoryBooking repositoryBooking;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoResBooking>> filter(DtoResBookingFilter dtoBookingFilter, int page, int size) {

    String query = SqlBookingFilterBuilderNative.build(dtoBookingFilter);
    int off = page * size;
    List<EntityResBooking> listEntities;
    if (query.equals("")) {
      listEntities = repositoryBooking.findBookingByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT res_booking.* FROM res_booking WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityResBooking.class);
      listEntities = (List<EntityResBooking>) filterQuery.getResultList();
    }
    List<DtoResBooking> listDtoResBooking = listEntities
        .stream()
        .map(DtoResBooking::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoResBooking);
  }

}