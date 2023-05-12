package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorial;
import com.puggysoft.dtos.pets.DtoPetsHistorialFilter;
import com.puggysoft.entities.pets.EntityPetsHistorial;
import com.puggysoft.repositories.pets.IRepositoryPetsHistorial;
import com.puggysoft.tools.pets.SqlPetsHistorialFilterBuilderNative;
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
public class ServicePetsHistorialGetFilter {

  @Autowired
  private IRepositoryPetsHistorial repositoryPetsHistorial;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoPetsHistorial>> filter(DtoPetsHistorialFilter dtoPetsHistorialFilter, int page,
      int size) {

    String query = SqlPetsHistorialFilterBuilderNative.build(dtoPetsHistorialFilter);
    int off = page * size;
    List<EntityPetsHistorial> listEntities;
    if (query.equals("")) {
      listEntities = repositoryPetsHistorial.findPetsHistorialByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT pets_historial.* FROM pets_historial WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityPetsHistorial.class);
      listEntities = (List<EntityPetsHistorial>) filterQuery.getResultList();
    }
    List<DtoPetsHistorial> listDtoPetsHistorial = listEntities
        .stream()
        .map(DtoPetsHistorial::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoPetsHistorial);
  }

}