package com.puggysoft.services.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.dtos.asistencia.DtoAsistFilter;
import com.puggysoft.entities.asistencia.EntityAsist;
import com.puggysoft.repositories.asistencia.IRepositoryAsist;
import com.puggysoft.tools.asistencia.SqlAsistFilterBuilderNative;
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
public class ServiceAsistGetFilter {

  @Autowired
  private IRepositoryAsist repositoryAsist;

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings(value = "unchecked")
  /** method for filter. */
  public ResponseEntity<List<DtoAsist>> filter(DtoAsistFilter dtoAsistFilter, int page, int size) {

    String query = SqlAsistFilterBuilderNative.build(dtoAsistFilter);
    int off = page * size;
    List<EntityAsist> listEntities;
    if (query.equals("")) {
      listEntities = repositoryAsist.findAsistByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT asistencia_control.* FROM asistencia_control WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityAsist.class);
      listEntities = (List<EntityAsist>) filterQuery.getResultList();
    }
    List<DtoAsist> listDtoAsist = listEntities
        .stream()
        .map(DtoAsist::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoAsist);
  }

}
