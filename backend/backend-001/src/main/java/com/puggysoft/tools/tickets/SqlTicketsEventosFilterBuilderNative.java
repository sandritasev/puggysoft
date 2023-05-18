package com.puggysoft.tools.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventosFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlTicketsEventosFilterBuilderNative {

  /** Constructor. */
  private SqlTicketsEventosFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoTicketsEventosFilter dtoTicketsEventosFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoTicketsEventosFilter.idCriteria,
        dtoTicketsEventosFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("nombre", dtoTicketsEventosFilter.nombreCriteria,
        dtoTicketsEventosFilter.nombreOperator);
    query = query + SqlFilterBuilder.getFilterQuery("short_name", dtoTicketsEventosFilter.shortNameCriteria,
        dtoTicketsEventosFilter.shortNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("cantidad_tickets", dtoTicketsEventosFilter.cantidadTicketsCriteria,
        dtoTicketsEventosFilter.cantidadTicketsOperator);
    query = query + SqlFilterBuilder.getFilterQuery("fecha_fin", dtoTicketsEventosFilter.fechaFinCriteria,
        dtoTicketsEventosFilter.fechaFinOperator);
    query = query + SqlFilterBuilder.getFilterQuery("fecha_inicio", dtoTicketsEventosFilter.fechaInicioCriteria,
        dtoTicketsEventosFilter.fechaInicioOperator);
    query = query + SqlFilterBuilder.getFilterQuery("aux", dtoTicketsEventosFilter.auxCriteria,
        dtoTicketsEventosFilter.auxOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoTicketsEventosFilter.tenantCriteria,
        dtoTicketsEventosFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoTicketsEventosFilter.createdByCriteria,
        dtoTicketsEventosFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoTicketsEventosFilter.updatedByCriteria,
        dtoTicketsEventosFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoTicketsEventosFilter.creationDateCriteria,
        dtoTicketsEventosFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoTicketsEventosFilter.updateDateCriteria,
        dtoTicketsEventosFilter.updateDateOperator);
    return query;
  }

}
