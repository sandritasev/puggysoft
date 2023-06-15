package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstadosFilter;
import com.puggysoft.entities.alcaldia.EntityUrbanismoEstados;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoEstados;
import com.puggysoft.tools.alcaldia.SqlUrbanismoEstadosFilterBuilderNative;
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
public class ServiceUrbanismoEstadosGetFilter {

  @Autowired
  private IRepositoryUrbanismoEstados repositoryUrbanismoEstados;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoUrbanismoEstados>> filter(
      DtoUrbanismoEstadosFilter dtoUrbanismoEstadosFilter, int page, int size) {

    String query = SqlUrbanismoEstadosFilterBuilderNative.build(dtoUrbanismoEstadosFilter);
    int off = page * size;
    List<EntityUrbanismoEstados> listEntities;
    if (query.equals("")) {
      listEntities = repositoryUrbanismoEstados.findUrbanismoEstadosByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT alc_urb_estados.* FROM alc_urb_estados WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityUrbanismoEstados.class);
      listEntities = (List<EntityUrbanismoEstados>) filterQuery.getResultList();
    }
    List<DtoUrbanismoEstados> listDtoUrbanismoEstados = listEntities
        .stream()
        .map(DtoUrbanismoEstados::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoUrbanismoEstados);
  }

}