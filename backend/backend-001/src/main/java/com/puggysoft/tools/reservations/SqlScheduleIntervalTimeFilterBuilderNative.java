package com.puggysoft.tools.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleIntervalTimeFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlScheduleIntervalTimeFilterBuilderNative {

  /** Constructor. */
  private SqlScheduleIntervalTimeFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoResScheduleIntervalTimeFilter dtoScheduleIntervalTimeFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("res_schedule_interval_time.id",
        dtoScheduleIntervalTimeFilter.idCriteria,
        dtoScheduleIntervalTimeFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("id_schedule", dtoScheduleIntervalTimeFilter.idScheduleCriteria,
        dtoScheduleIntervalTimeFilter.idScheduleOperator);
    query = query + SqlFilterBuilder.getFilterQuery("id_interval_time",
        dtoScheduleIntervalTimeFilter.idIntervalTimeCriteria,
        dtoScheduleIntervalTimeFilter.idIntervalTimeOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoScheduleIntervalTimeFilter.tenantCriteria,
        dtoScheduleIntervalTimeFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoScheduleIntervalTimeFilter.createdByCriteria,
        dtoScheduleIntervalTimeFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoScheduleIntervalTimeFilter.updatedByCriteria,
        dtoScheduleIntervalTimeFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("creation_date", dtoScheduleIntervalTimeFilter.creationDateCriteria,
            dtoScheduleIntervalTimeFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoScheduleIntervalTimeFilter.updateDateCriteria,
        dtoScheduleIntervalTimeFilter.updateDateOperator);
    return query;
  }

}
