package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCalificaciones;
import com.puggysoft.dtos.escuela.DtoEscuelaCalificacionesFilter;
import com.puggysoft.entities.escuela.EntityEscuelaCalificaciones;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaCalificaciones;
import com.puggysoft.tools.escuela.SqlEscuelaCalificacionesFilterBuilderNative;
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
public class ServiceEscuelaCalificacionesGetFilter {

  @Autowired
  private IRepositoryEscuelaCalificaciones repositoryEscuelaCalificaciones;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoEscuelaCalificaciones>> filter(
      DtoEscuelaCalificacionesFilter dtoEscuelaCalificacionesFilter, int page, int size) {

    String query = SqlEscuelaCalificacionesFilterBuilderNative.build(dtoEscuelaCalificacionesFilter);
    int off = page * size;
    List<EntityEscuelaCalificaciones> listEntities;
    if (query.equals("")) {
      listEntities = repositoryEscuelaCalificaciones.findEscuelaCalificacionesByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT escuela_calificaciones.* FROM escuela_calificaciones WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityEscuelaCalificaciones.class);
      listEntities = (List<EntityEscuelaCalificaciones>) filterQuery.getResultList();
    }
    List<DtoEscuelaCalificaciones> listDtoEscuelaCalificaciones = listEntities
        .stream()
        .map(DtoEscuelaCalificaciones::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoEscuelaCalificaciones);
  }

}