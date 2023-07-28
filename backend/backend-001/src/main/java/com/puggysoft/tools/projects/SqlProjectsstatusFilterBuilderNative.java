package com.puggysoft.tools.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatusFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlProjectsstatusFilterBuilderNative {

  /** Constructor. */
  private SqlProjectsstatusFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoProjectsStatusFilter dtoProjectsstatusFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoProjectsstatusFilter.nameCriteria,
        dtoProjectsstatusFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("short_name", dtoProjectsstatusFilter.shortNameCriteria,
        dtoProjectsstatusFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant", dtoProjectsstatusFilter.tenantCriteria,
        dtoProjectsstatusFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoProjectsstatusFilter.createdByCriteria,
        dtoProjectsstatusFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoProjectsstatusFilter.updatedByCriteria,
        dtoProjectsstatusFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date",
        dtoProjectsstatusFilter.creationDateCriteria,
        dtoProjectsstatusFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date",
        dtoProjectsstatusFilter.updateDateCriteria,
        dtoProjectsstatusFilter.updateDateOperator);
    return query;
  }

}