package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotas;
import com.puggysoft.dtos.escuela.DtoEscuelaNotasFilter;
import com.puggysoft.entities.escuela.EntityEscuelaNotas;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaNotas;
import com.puggysoft.tools.escuela.SqlEscuelaNotasFilterBuilderNative;
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
public class ServiceEscuelaNotasGetFilter {

  @Autowired
  private IRepositoryEscuelaNotas repositoryEscuelaNotas;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoEscuelaNotas>> filter(DtoEscuelaNotasFilter dtoEscuelaNotasFilter, int page, int size) {

    String query = SqlEscuelaNotasFilterBuilderNative.build(dtoEscuelaNotasFilter);
    int off = page * size;
    List<EntityEscuelaNotas> listEntities;
    if (query.equals("")) {
      listEntities = repositoryEscuelaNotas.findEscuelaNotasByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT escuela_notas.* FROM escuela_notas WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityEscuelaNotas.class);
      listEntities = (List<EntityEscuelaNotas>) filterQuery.getResultList();
    }
    List<DtoEscuelaNotas> listDtoEscuelaNotas = listEntities
        .stream()
        .map(DtoEscuelaNotas::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoEscuelaNotas);
  }

}