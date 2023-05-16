package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResResource;
import com.puggysoft.dtos.reservations.DtoResResourceFilter;
import com.puggysoft.entities.reservations.EntityResResource;
import com.puggysoft.repositories.reservations.IRepositoryResource;
import com.puggysoft.tools.reservations.SqlResourceFilterBuilderNative;
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
public class ServiceResourceGetFilter {

  @Autowired
  private IRepositoryResource repositoryResource;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoResResource>> filter(DtoResResourceFilter dtoResourceFilter, int page, int size) {

    String query = SqlResourceFilterBuilderNative.build(dtoResourceFilter);
    int off = page * size;
    List<EntityResResource> listEntities;
    if (query.equals("")) {
      listEntities = repositoryResource.findResourceByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT res_resources.* FROM res_resources WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityResResource.class);
      listEntities = (List<EntityResResource>) filterQuery.getResultList();
    }
    List<DtoResResource> listDtoResResource = listEntities
        .stream()
        .map(DtoResResource::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoResResource);
  }

}