package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPetsFilter;
import com.puggysoft.repositories.pets.IRepositoryPets;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.pets.SqlPetsFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServicePetsGetFilterSize {

  @Autowired
  private IRepositoryPets repositoryPets;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoPetsFilter dtoPetsFilter, Long pageSize) {

    String query = SqlPetsFilterBuilderNative.build(dtoPetsFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryPets.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM pets_pets WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
