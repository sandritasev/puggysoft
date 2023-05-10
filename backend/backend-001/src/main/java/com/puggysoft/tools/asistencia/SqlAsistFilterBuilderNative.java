package com.puggysoft.tools.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsistFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlAsistFilterBuilderNative {

  /** Constructor. */
  private SqlAsistFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoAsistFilter dtoAsistFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoAsistFilter.idCriteria,
        dtoAsistFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("persona", dtoAsistFilter.personaCriteria,
        dtoAsistFilter.personaOperator);
    query = query + SqlFilterBuilder.getFilterQuery("detalle", dtoAsistFilter.detalleCriteria,
        dtoAsistFilter.detalleOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoAsistFilter.tenantCriteria,
        dtoAsistFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoAsistFilter.createdByCriteria,
        dtoAsistFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoAsistFilter.updatedByCriteria,
        dtoAsistFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoAsistFilter.creationDateCriteria,
        dtoAsistFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoAsistFilter.updateDateCriteria,
        dtoAsistFilter.updateDateOperator);
    return query;
  }

}
