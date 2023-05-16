package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTime;
import com.puggysoft.dtos.reservations.DtoResIntervalTimeFilter;
import com.puggysoft.entities.reservations.EntityResIntervalTime;
import com.puggysoft.repositories.reservations.IRepositoryIntervalTime;
import com.puggysoft.tools.reservations.SqlIntervalTimeFilterBuilderNative;
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
public class ServiceIntervalTimeGetFilter {

  @Autowired
  private IRepositoryIntervalTime repositoryIntervalTime;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoResIntervalTime>> filter(DtoResIntervalTimeFilter dtoIntervalTimeFilter, int page,
      int size) {

    String query = SqlIntervalTimeFilterBuilderNative.build(dtoIntervalTimeFilter);
    int off = page * size;
    List<EntityResIntervalTime> listEntities;
    if (query.equals("")) {
      listEntities = repositoryIntervalTime.findIntervalTimeByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT res_interval_time.* FROM res_interval_time WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityResIntervalTime.class);
      listEntities = (List<EntityResIntervalTime>) filterQuery.getResultList();
    }
    List<DtoResIntervalTime> listDtoResIntervalTime = listEntities
        .stream()
        .map(DtoResIntervalTime::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoResIntervalTime);
  }

}