package com.puggysoft.tools.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasksFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlProjectstasksFilterBuilderNative {

  /** Constructor. */
  private SqlProjectstasksFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoProjectsTasksFilter dtoProjectstasksFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoProjectstasksFilter.nameCriteria,
        dtoProjectstasksFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("short_name", dtoProjectstasksFilter.shortNameCriteria,
        dtoProjectstasksFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("project_short_name",
        dtoProjectstasksFilter.projectShortNameCriteria,
        dtoProjectstasksFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("status", dtoProjectstasksFilter.statusCriteria,
        dtoProjectstasksFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("description",
        dtoProjectstasksFilter.descriptionCriteria,
        dtoProjectstasksFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("responsible",
        dtoProjectstasksFilter.responsibleCriteria,
        dtoProjectstasksFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant", dtoProjectstasksFilter.tenantCriteria,
        dtoProjectstasksFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoProjectstasksFilter.createdByCriteria,
        dtoProjectstasksFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoProjectstasksFilter.updatedByCriteria,
        dtoProjectstasksFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date",
        dtoProjectstasksFilter.creationDateCriteria,
        dtoProjectstasksFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date",
        dtoProjectstasksFilter.updateDateCriteria,
        dtoProjectstasksFilter.updateDateOperator);
    return query;
  }

}