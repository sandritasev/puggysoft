package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujo;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujoFilter;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramiteFlujo;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramiteFlujo;
import com.puggysoft.tools.alcaldia.SqlUrbanismoTramiteFlujoFilterBuilderNative;
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
public class ServiceUrbanismoTramiteFlujoGetFilter {

  @Autowired
  private IRepositoryUrbanismoTramiteFlujo repositoryUrbanismoTramiteFlujo;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoUrbanismoTramiteFlujo>> filter(
      DtoUrbanismoTramiteFlujoFilter dtoUrbanismoTramiteFlujoFilter, int page, int size) {

    String query = SqlUrbanismoTramiteFlujoFilterBuilderNative.build(dtoUrbanismoTramiteFlujoFilter);
    int off = page * size;
    List<EntityUrbanismoTramiteFlujo> listEntities;
    if (query.equals("")) {
      listEntities = repositoryUrbanismoTramiteFlujo.findUrbanismoTramiteFlujoByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT alc_urb_tramite_flujo.* FROM alc_urb_tramite_flujo WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityUrbanismoTramiteFlujo.class);
      listEntities = (List<EntityUrbanismoTramiteFlujo>) filterQuery.getResultList();
    }
    List<DtoUrbanismoTramiteFlujo> listDtoUrbanismoTramiteFlujo = listEntities
        .stream()
        .map(DtoUrbanismoTramiteFlujo::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoUrbanismoTramiteFlujo);
  }

}