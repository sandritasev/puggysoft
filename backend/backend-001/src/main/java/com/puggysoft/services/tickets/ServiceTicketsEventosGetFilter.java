package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventos;
import com.puggysoft.dtos.tickets.DtoTicketsEventosFilter;
import com.puggysoft.entities.tickets.EntityTicketsEventos;
import com.puggysoft.repositories.tickets.IRepositoryTicketsEventos;
import com.puggysoft.tools.tickets.SqlTicketsEventosFilterBuilderNative;
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
public class ServiceTicketsEventosGetFilter {

  @Autowired
  private IRepositoryTicketsEventos repositoryTicketsEventos;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoTicketsEventos>> filter(DtoTicketsEventosFilter dtoTicketsEventosFilter, int page,
      int size) {

    String query = SqlTicketsEventosFilterBuilderNative.build(dtoTicketsEventosFilter);
    int off = page * size;
    List<EntityTicketsEventos> listEntities;
    if (query.equals("")) {
      listEntities = repositoryTicketsEventos.findTicketsEventosByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT tickets_eventos.* FROM tickets_eventos WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityTicketsEventos.class);
      listEntities = (List<EntityTicketsEventos>) filterQuery.getResultList();
    }
    List<DtoTicketsEventos> listDtoTicketsEventos = listEntities
        .stream()
        .map(DtoTicketsEventos::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoTicketsEventos);
  }

}