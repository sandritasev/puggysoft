package com.puggysoft.tools.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlResourceFilterBuilderNative {

  /** Constructor. */
  private SqlResourceFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoResResourceFilter dtoResourceFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("res_resources.id", dtoResourceFilter.idCriteria,
        dtoResourceFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoResourceFilter.nameCriteria,
        dtoResourceFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("price_interval", dtoResourceFilter.priceIntervalCriteria,
        dtoResourceFilter.priceIntervalOperator);
    query = query + SqlFilterBuilder.getFilterQuery("description", dtoResourceFilter.descriptionCriteria,
        dtoResourceFilter.descriptionOperator);
    query = query + SqlFilterBuilder.getFilterQuery("aux", dtoResourceFilter.auxCriteria,
        dtoResourceFilter.auxOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoResourceFilter.tenantCriteria,
        dtoResourceFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoResourceFilter.createdByCriteria,
        dtoResourceFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoResourceFilter.updatedByCriteria,
        dtoResourceFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoResourceFilter.creationDateCriteria,
        dtoResourceFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoResourceFilter.updateDateCriteria,
        dtoResourceFilter.updateDateOperator);
    return query;
  }

}