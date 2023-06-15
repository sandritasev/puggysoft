package com.puggysoft.tools.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitosFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlUrbanismoRequisitosFilterBuilderNative {

  /** Constructor. */
  private SqlUrbanismoRequisitosFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoUrbanismoRequisitosFilter dtoUrbanismoRequisitosFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.id",
        dtoUrbanismoRequisitosFilter.idCriteria,
        dtoUrbanismoRequisitosFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.nombre",
        dtoUrbanismoRequisitosFilter.nombreCriteria,
        dtoUrbanismoRequisitosFilter.nombreOperator);
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.nombre_corto",
        dtoUrbanismoRequisitosFilter.nombreCortoCriteria,
        dtoUrbanismoRequisitosFilter.nombreCortoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.tenant ",
        dtoUrbanismoRequisitosFilter.tenantCriteria,
        dtoUrbanismoRequisitosFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.created_by",
            dtoUrbanismoRequisitosFilter.createdByCriteria,
            dtoUrbanismoRequisitosFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.updated_by",
            dtoUrbanismoRequisitosFilter.updatedByCriteria,
            dtoUrbanismoRequisitosFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.creation_date",
            dtoUrbanismoRequisitosFilter.creationDateCriteria,
            dtoUrbanismoRequisitosFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_requisitos.update_date",
            dtoUrbanismoRequisitosFilter.updateDateCriteria,
            dtoUrbanismoRequisitosFilter.updateDateOperator);
    return query;
  }

}
