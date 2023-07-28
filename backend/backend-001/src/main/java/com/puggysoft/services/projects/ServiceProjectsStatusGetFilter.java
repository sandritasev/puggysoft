package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.dtos.projects.DtoProjectsStatusFilter;
import com.puggysoft.entities.projects.EntityProjectsStatus;
import com.puggysoft.repositories.projects.IRepositoryProjectsStatus;
import com.puggysoft.tools.projects.SqlProjectsstatusFilterBuilderNative;
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
public class ServiceProjectsStatusGetFilter {

  @Autowired
  private IRepositoryProjectsStatus repositoryProjectsstatus;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  public ResponseEntity<List<DtoProjectsStatus>> filter(DtoProjectsStatusFilter dtoProjectsstatusFilter, int page,
      int size) {

    String query = SqlProjectsstatusFilterBuilderNative.build(dtoProjectsstatusFilter);
    int off = page * size;
    List<EntityProjectsStatus> listEntities;
    if (query.equals("")) {
      listEntities = repositoryProjectsstatus.findProjectsstatusByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT todo_status.* FROM todo_status WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityProjectsStatus.class);
      listEntities = (List<EntityProjectsStatus>) filterQuery.getResultList();

    }
    List<DtoProjectsStatus> listDtoProjectsstatus = listEntities
        .stream()
        .map(DtoProjectsStatus::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoProjectsstatus);
  }

}
