package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujoFilter;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramiteFlujo;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.alcaldia.SqlUrbanismoTramiteFlujoFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceUrbanismoTramiteFlujoGetFilterSize {

  @Autowired
  private IRepositoryUrbanismoTramiteFlujo repositoryUrbanismoTramiteFlujo;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoUrbanismoTramiteFlujoFilter dtoUrbanismoTramiteFlujoFilter,
      Long pageSize) {

    String query = SqlUrbanismoTramiteFlujoFilterBuilderNative.build(dtoUrbanismoTramiteFlujoFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryUrbanismoTramiteFlujo.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM alc_urb_tramite_flujo WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
