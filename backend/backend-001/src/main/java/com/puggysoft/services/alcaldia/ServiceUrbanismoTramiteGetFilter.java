package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFilter;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramite;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramite;
import com.puggysoft.tools.alcaldia.SqlUrbanismoTramiteFilterBuilderNative;
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
public class ServiceUrbanismoTramiteGetFilter {

  @Autowired
  private IRepositoryUrbanismoTramite repositoryUrbanismoTramite;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoUrbanismoTramite>> filter(
      DtoUrbanismoTramiteFilter dtoUrbanismoTramiteFilter, int page, int size) {

    String query = SqlUrbanismoTramiteFilterBuilderNative.build(dtoUrbanismoTramiteFilter);
    int off = page * size;
    List<EntityUrbanismoTramite> listEntities;
    if (query.equals("")) {
      listEntities = repositoryUrbanismoTramite.findUrbanismoTramiteByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT alc_urb_tramite.* FROM alc_urb_tramite WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityUrbanismoTramite.class);
      listEntities = (List<EntityUrbanismoTramite>) filterQuery.getResultList();
    }
    List<DtoUrbanismoTramite> listDtoUrbanismoTramite = listEntities
        .stream()
        .map(DtoUrbanismoTramite::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoUrbanismoTramite);
  }

}