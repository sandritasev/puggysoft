package com.puggysoft.tools.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTimeFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlIntervalTimeFilterBuilderNative {

  /** Constructor. */
  private SqlIntervalTimeFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoResIntervalTimeFilter dtoIntervalTimeFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("res_interval_time.id", dtoIntervalTimeFilter.idCriteria,
        dtoIntervalTimeFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoIntervalTimeFilter.nameCriteria,
        dtoIntervalTimeFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("start_time", dtoIntervalTimeFilter.startTimeCriteria,
        dtoIntervalTimeFilter.startTimeOperator);
    query = query + SqlFilterBuilder.getFilterQuery("end_time", dtoIntervalTimeFilter.endTimeCriteria,
        dtoIntervalTimeFilter.endTimeOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoIntervalTimeFilter.tenantCriteria,
        dtoIntervalTimeFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoIntervalTimeFilter.createdByCriteria,
        dtoIntervalTimeFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoIntervalTimeFilter.updatedByCriteria,
        dtoIntervalTimeFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoIntervalTimeFilter.creationDateCriteria,
        dtoIntervalTimeFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoIntervalTimeFilter.updateDateCriteria,
        dtoIntervalTimeFilter.updateDateOperator);
    return query;
  }

}
