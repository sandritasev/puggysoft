package com.puggysoft.tools.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageFieldFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlStorageFieldFilterBuilderNative {

  /** Constructor. */
  private SqlStorageFieldFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoStorageFieldFilter dtoStorageFieldFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("storage_field.id",
        dtoStorageFieldFilter.idCriteria,
        dtoStorageFieldFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_field.name",
        dtoStorageFieldFilter.nameCriteria,
        dtoStorageFieldFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_field.short_name",
        dtoStorageFieldFilter.shortNameCriteria,
        dtoStorageFieldFilter.shortNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_field.type",
        dtoStorageFieldFilter.typeCriteria,
        dtoStorageFieldFilter.typeOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_field.textbox_option",
        dtoStorageFieldFilter.textboxOptionCriteria,
        dtoStorageFieldFilter.textboxOptionOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_field.tenant ",
        dtoStorageFieldFilter.tenantCriteria,
        dtoStorageFieldFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_field.created_by",
            dtoStorageFieldFilter.createdByCriteria,
            dtoStorageFieldFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_field.updated_by",
            dtoStorageFieldFilter.updatedByCriteria,
            dtoStorageFieldFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_field.creation_date",
            dtoStorageFieldFilter.creationDateCriteria,
            dtoStorageFieldFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_field.update_date",
            dtoStorageFieldFilter.updateDateCriteria,
            dtoStorageFieldFilter.updateDateOperator);
    return query;
  }

}
