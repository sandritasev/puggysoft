package com.puggysoft.tools.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceScheduleFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlResourceScheduleFilterBuilderNative {

  /** Constructor. */
  private SqlResourceScheduleFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoResResourceScheduleFilter dtoResourceScheduleFilter) {
    String query = "";
    query = query
        + SqlFilterBuilder.getFilterQuery("res_resources_schedule.id", dtoResourceScheduleFilter.idCriteria,
            dtoResourceScheduleFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("id_schedule", dtoResourceScheduleFilter.idScheduleCriteria,
        dtoResourceScheduleFilter.idScheduleOperator);
    query = query + SqlFilterBuilder.getFilterQuery("id_resource", dtoResourceScheduleFilter.idResourceCriteria,
        dtoResourceScheduleFilter.idResourceOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoResourceScheduleFilter.tenantCriteria,
        dtoResourceScheduleFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoResourceScheduleFilter.createdByCriteria,
        dtoResourceScheduleFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoResourceScheduleFilter.updatedByCriteria,
        dtoResourceScheduleFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoResourceScheduleFilter.creationDateCriteria,
        dtoResourceScheduleFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoResourceScheduleFilter.updateDateCriteria,
        dtoResourceScheduleFilter.updateDateOperator);
    return query;
  }

}