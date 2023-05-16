package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceSchedule;
import com.puggysoft.dtos.reservations.DtoResResourceScheduleFilter;
import com.puggysoft.entities.reservations.EntityResResourceSchedule;
import com.puggysoft.repositories.reservations.IRepositoryResourceSchedule;
import com.puggysoft.tools.reservations.SqlResourceScheduleFilterBuilderNative;
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
public class ServiceResourceScheduleGetFilter {

  @Autowired
  private IRepositoryResourceSchedule repositoryResourceSchedule;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoResResourceSchedule>> filter(DtoResResourceScheduleFilter dtoResourceScheduleFilter,
      int page, int size) {

    String query = SqlResourceScheduleFilterBuilderNative.build(dtoResourceScheduleFilter);
    int off = page * size;
    List<EntityResResourceSchedule> listEntities;
    if (query.equals("")) {
      listEntities = repositoryResourceSchedule.findResourceScheduleByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT res_resources_schedule.* FROM res_resources_schedule WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityResResourceSchedule.class);
      listEntities = (List<EntityResResourceSchedule>) filterQuery.getResultList();
    }
    List<DtoResResourceSchedule> listDtoResResourceSchedule = listEntities
        .stream()
        .map(DtoResResourceSchedule::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoResResourceSchedule);
  }

}