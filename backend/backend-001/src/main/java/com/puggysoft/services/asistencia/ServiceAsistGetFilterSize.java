package com.puggysoft.services.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsistFilter;
import com.puggysoft.repositories.asistencia.IRepositoryAsist;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.asistencia.SqlAsistFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceAsistGetFilterSize {

  @Autowired
  private IRepositoryAsist repositoryAsist;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoAsistFilter dtoAsistFilter, Long pageSize) {

    String query = SqlAsistFilterBuilderNative.build(dtoAsistFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryAsist.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM asistencia_control WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
