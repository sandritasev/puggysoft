package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaCursos;
import com.puggysoft.dtos.escuela.DtoEscuelaCursosFilter;
import com.puggysoft.entities.escuela.EntityEscuelaCursos;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaCursos;
import com.puggysoft.tools.escuela.SqlEscuelaCursosFilterBuilderNative;
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
public class ServiceEscuelaCursosGetFilter {

  @Autowired
  private IRepositoryEscuelaCursos repositoryEscuelaCursos;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoEscuelaCursos>> filter(DtoEscuelaCursosFilter dtoEscuelaCursosFilter, int page,
      int size) {

    String query = SqlEscuelaCursosFilterBuilderNative.build(dtoEscuelaCursosFilter);
    int off = page * size;
    List<EntityEscuelaCursos> listEntities;
    if (query.equals("")) {
      listEntities = repositoryEscuelaCursos.findEscuelaCursosByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT escuela_cursos.* FROM escuela_cursos WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityEscuelaCursos.class);
      listEntities = (List<EntityEscuelaCursos>) filterQuery.getResultList();
    }
    List<DtoEscuelaCursos> listDtoEscuelaCursos = listEntities
        .stream()
        .map(DtoEscuelaCursos::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoEscuelaCursos);
  }

}