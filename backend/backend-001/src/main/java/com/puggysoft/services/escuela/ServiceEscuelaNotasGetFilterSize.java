package com.puggysoft.services.escuela;

import com.puggysoft.dtos.escuela.DtoEscuelaNotasFilter;
import com.puggysoft.repositories.escuela.IRepositoryEscuelaNotas;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.escuela.SqlEscuelaNotasFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceEscuelaNotasGetFilterSize {

  @Autowired
  private IRepositoryEscuelaNotas repositoryEscuelaNotas;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoEscuelaNotasFilter dtoEscuelaNotasFilter, Long pageSize) {

    String query = SqlEscuelaNotasFilterBuilderNative.build(dtoEscuelaNotasFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryEscuelaNotas.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM escuela_notas WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
