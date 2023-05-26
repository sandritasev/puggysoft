package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventosFilter;
import com.puggysoft.repositories.tickets.IRepositoryTicketsEventos;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.tickets.SqlTicketsEventosFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceTicketsEventosGetFilterSize {

  @Autowired
  private IRepositoryTicketsEventos repositoryTicketsEventos;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoTicketsEventosFilter dtoTicketsEventosFilter, Long pageSize) {

    String query = SqlTicketsEventosFilterBuilderNative.build(dtoTicketsEventosFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryTicketsEventos.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM tickets_eventos WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
