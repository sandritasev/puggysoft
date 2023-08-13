package com.puggysoft.tools.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaFieldFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlStorageSchemaFieldFilterBuilderNative {

  /** Constructor. */
  private SqlStorageSchemaFieldFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoStorageSchemaFieldFilter dtoStorageSchemaFieldFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema_field.id",
        dtoStorageSchemaFieldFilter.idCriteria,
        dtoStorageSchemaFieldFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema_field.schema_",
        dtoStorageSchemaFieldFilter.schemaCriteria,
        dtoStorageSchemaFieldFilter.schemaOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema_field.field",
        dtoStorageSchemaFieldFilter.fieldCriteria,
        dtoStorageSchemaFieldFilter.fieldOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_schema_field.tenant ",
        dtoStorageSchemaFieldFilter.tenantCriteria,
        dtoStorageSchemaFieldFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema_field.created_by",
            dtoStorageSchemaFieldFilter.createdByCriteria,
            dtoStorageSchemaFieldFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema_field.updated_by",
            dtoStorageSchemaFieldFilter.updatedByCriteria,
            dtoStorageSchemaFieldFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema_field.creation_date",
            dtoStorageSchemaFieldFilter.creationDateCriteria,
            dtoStorageSchemaFieldFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_schema_field.update_date",
            dtoStorageSchemaFieldFilter.updateDateCriteria,
            dtoStorageSchemaFieldFilter.updateDateOperator);
    return query;
  }

}
