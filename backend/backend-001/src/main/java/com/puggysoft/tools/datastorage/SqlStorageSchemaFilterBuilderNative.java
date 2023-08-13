package com.puggysoft.tools.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlStorageSchemaFilterBuilderNative {

  /** Constructor. */
  private SqlStorageSchemaFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoStorageSchemaFilter dtoStorageSchemaFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema.id",
        dtoStorageSchemaFilter.idCriteria,
        dtoStorageSchemaFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema.name",
        dtoStorageSchemaFilter.nameCriteria,
        dtoStorageSchemaFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema.short_name",
        dtoStorageSchemaFilter.shortNameCriteria,
        dtoStorageSchemaFilter.shortNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema.tenant ",
        dtoStorageSchemaFilter.tenantCriteria,
        dtoStorageSchemaFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema.created_by",
            dtoStorageSchemaFilter.createdByCriteria,
            dtoStorageSchemaFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema.updated_by",
            dtoStorageSchemaFilter.updatedByCriteria,
            dtoStorageSchemaFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema.creation_date",
            dtoStorageSchemaFilter.creationDateCriteria,
            dtoStorageSchemaFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema.update_date",
            dtoStorageSchemaFilter.updateDateCriteria,
            dtoStorageSchemaFilter.updateDateOperator);
    return query;
  }

}
