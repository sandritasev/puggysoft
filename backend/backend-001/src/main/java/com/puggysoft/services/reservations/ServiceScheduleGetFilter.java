package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResSchedule;
import com.puggysoft.dtos.reservations.DtoResScheduleFilter;
import com.puggysoft.entities.reservations.EntityResSchedule;
import com.puggysoft.repositories.reservations.IRepositorySchedule;
import com.puggysoft.tools.reservations.SqlScheduleFilterBuilderNative;
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
public class ServiceScheduleGetFilter {

  @Autowired
  private IRepositorySchedule repositorySchedule;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoResSchedule>> filter(DtoResScheduleFilter dtoScheduleFilter, int page, int size) {

    String query = SqlScheduleFilterBuilderNative.build(dtoScheduleFilter);
    int off = page * size;
    List<EntityResSchedule> listEntities;
    if (query.equals("")) {
      listEntities = repositorySchedule.findScheduleByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT res_schedule.* FROM res_schedule WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityResSchedule.class);
      listEntities = (List<EntityResSchedule>) filterQuery.getResultList();
    }
    List<DtoResSchedule> listDtoResSchedule = listEntities
        .stream()
        .map(DtoResSchedule::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoResSchedule);
  }

}