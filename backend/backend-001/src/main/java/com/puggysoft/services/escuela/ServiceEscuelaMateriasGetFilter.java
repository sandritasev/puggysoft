package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaMaterias;
import com.puggysoft.dtos.escuela.DtoEscuelaMateriasFilter;
import com.puggysoft.entities.escuela.EntityEscuelaMaterias;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaMaterias;
import com.puggysoft.tools.escuela.SqlEscuelaMateriasFilterBuilderNative;
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
public class ServiceEscuelaMateriasGetFilter {

  @Autowired
  private IRepositoryEscuelaMaterias repositoryEscuelaMaterias;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoEscuelaMaterias>> filter(DtoEscuelaMateriasFilter dtoEscuelaMateriasFilter, int page,
      int size) {

    String query = SqlEscuelaMateriasFilterBuilderNative.build(dtoEscuelaMateriasFilter);
    int off = page * size;
    List<EntityEscuelaMaterias> listEntities;
    if (query.equals("")) {
      listEntities = repositoryEscuelaMaterias.findEscuelaMateriasByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT escuela_materias.* FROM escuela_materias WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityEscuelaMaterias.class);
      listEntities = (List<EntityEscuelaMaterias>) filterQuery.getResultList();
    }
    List<DtoEscuelaMaterias> listDtoEscuelaMaterias = listEntities
        .stream()
        .map(DtoEscuelaMaterias::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoEscuelaMaterias);
  }

}