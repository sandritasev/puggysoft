package com.puggysoft.tools.projects;

import com.puggysoft.dtos.projects.DtoProjectsProFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlProjectsproFilterBuilderNative {

  /** Constructor. */
  private SqlProjectsproFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoProjectsProFilter dtoProjectsproFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoProjectsproFilter.nameCriteria,
        dtoProjectsproFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("short_name", dtoProjectsproFilter.shortNameCriteria,
        dtoProjectsproFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("status", dtoProjectsproFilter.statusCriteria,
        dtoProjectsproFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("description", dtoProjectsproFilter.descriptionCriteria,
        dtoProjectsproFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("responsible", dtoProjectsproFilter.responsibleCriteria,
        dtoProjectsproFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant", dtoProjectsproFilter.tenantCriteria,
        dtoProjectsproFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoProjectsproFilter.createdByCriteria,
        dtoProjectsproFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoProjectsproFilter.updatedByCriteria,
        dtoProjectsproFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date",
        dtoProjectsproFilter.creationDateCriteria,
        dtoProjectsproFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoProjectsproFilter.updateDateCriteria,
        dtoProjectsproFilter.updateDateOperator);
    return query;
  }

}