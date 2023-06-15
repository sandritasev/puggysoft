package com.puggysoft.tools.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlUrbanismoTramiteFilterBuilderNative {

  /** Constructor. */
  private SqlUrbanismoTramiteFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoUrbanismoTramiteFilter dtoUrbanismoTramiteFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.id",
        dtoUrbanismoTramiteFilter.idCriteria,
        dtoUrbanismoTramiteFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.nombre",
        dtoUrbanismoTramiteFilter.nombreCriteria,
        dtoUrbanismoTramiteFilter.nombreOperator);
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.nombre_corto",
        dtoUrbanismoTramiteFilter.nombreCortoCriteria,
        dtoUrbanismoTramiteFilter.nombreCortoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.tenant ",
        dtoUrbanismoTramiteFilter.tenantCriteria,
        dtoUrbanismoTramiteFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.created_by",
            dtoUrbanismoTramiteFilter.createdByCriteria,
            dtoUrbanismoTramiteFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.updated_by",
            dtoUrbanismoTramiteFilter.updatedByCriteria,
            dtoUrbanismoTramiteFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.creation_date",
            dtoUrbanismoTramiteFilter.creationDateCriteria,
            dtoUrbanismoTramiteFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("alc_urb_tramite.update_date",
            dtoUrbanismoTramiteFilter.updateDateCriteria,
            dtoUrbanismoTramiteFilter.updateDateOperator);
    return query;
  }

}
