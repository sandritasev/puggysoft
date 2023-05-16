package com.puggysoft.tools.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlScheduleFilterBuilderNative {

  /** Constructor. */
  private SqlScheduleFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoResScheduleFilter dtoScheduleFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("res_schedules.id", dtoScheduleFilter.idCriteria,
        dtoScheduleFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoScheduleFilter.nameCriteria,
        dtoScheduleFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoScheduleFilter.tenantCriteria,
        dtoScheduleFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoScheduleFilter.createdByCriteria,
        dtoScheduleFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoScheduleFilter.updatedByCriteria,
        dtoScheduleFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoScheduleFilter.creationDateCriteria,
        dtoScheduleFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoScheduleFilter.updateDateCriteria,
        dtoScheduleFilter.updateDateOperator);
    return query;
  }

}
