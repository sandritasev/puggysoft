package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTickets;
import com.puggysoft.dtos.tickets.DtoTicketsFilter;
import com.puggysoft.entities.tickets.EntityTickets;
import com.puggysoft.repositories.tickets.IRepositoryTickets;
import com.puggysoft.tools.tickets.SqlTicketsFilterBuilderNative;
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
public class ServiceTicketsGetFilter {

  @Autowired
  private IRepositoryTickets repositoryTickets;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoTickets>> filter(DtoTicketsFilter dtoTicketsFilter, int page, int size) {

    String query = SqlTicketsFilterBuilderNative.build(dtoTicketsFilter);
    int off = page * size;
    List<EntityTickets> listEntities;
    if (query.equals("")) {
      listEntities = repositoryTickets.findTicketsByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT tickets.* FROM tickets WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityTickets.class);
      listEntities = (List<EntityTickets>) filterQuery.getResultList();
    }
    List<DtoTickets> listDtoTickets = listEntities
        .stream()
        .map(DtoTickets::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoTickets);
  }

}