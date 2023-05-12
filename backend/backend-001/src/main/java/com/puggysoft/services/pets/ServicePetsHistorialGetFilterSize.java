package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorialFilter;
import com.puggysoft.repositories.pets.IRepositoryPetsHistorial;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.pets.SqlPetsHistorialFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServicePetsHistorialGetFilterSize {

  @Autowired
  private IRepositoryPetsHistorial repositoryPetsHistorial;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoPetsHistorialFilter dtoPetsHistorialFilter, Long pageSize) {

    String query = SqlPetsHistorialFilterBuilderNative.build(dtoPetsHistorialFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryPetsHistorial.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM pets_historial WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}