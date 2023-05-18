package com.puggysoft.tools.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlTicketsFilterBuilderNative {

  /** Constructor. */
  private SqlTicketsFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoTicketsFilter dtoTicketsFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoTicketsFilter.idCriteria,
        dtoTicketsFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("evento", dtoTicketsFilter.eventoCriteria,
        dtoTicketsFilter.eventoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("uuid", dtoTicketsFilter.uuidCriteria,
        dtoTicketsFilter.uuidOperator);
    query = query + SqlFilterBuilder.getFilterQuery("used", dtoTicketsFilter.usedCriteria,
        dtoTicketsFilter.usedOperator);
    query = query + SqlFilterBuilder.getFilterQuery("cliente", dtoTicketsFilter.clienteCriteria,
        dtoTicketsFilter.clienteOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoTicketsFilter.tenantCriteria,
        dtoTicketsFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoTicketsFilter.createdByCriteria,
        dtoTicketsFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoTicketsFilter.updatedByCriteria,
        dtoTicketsFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoTicketsFilter.creationDateCriteria,
        dtoTicketsFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoTicketsFilter.updateDateCriteria,
        dtoTicketsFilter.updateDateOperator);
    return query;
  }

}
