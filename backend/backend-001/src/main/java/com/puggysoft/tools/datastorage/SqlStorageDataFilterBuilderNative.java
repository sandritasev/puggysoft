package com.puggysoft.tools.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageDataFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlStorageDataFilterBuilderNative {

  /** Constructor. */
  private SqlStorageDataFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoStorageDataFilter dtoStorageDataFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("storage_data.id",
        dtoStorageDataFilter.idCriteria,
        dtoStorageDataFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_data.record",
        dtoStorageDataFilter.recordCriteria,
        dtoStorageDataFilter.recordOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_data.field",
        dtoStorageDataFilter.fieldCriteria,
        dtoStorageDataFilter.fieldOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_data.field_value",
        dtoStorageDataFilter.fieldValueCriteria,
        dtoStorageDataFilter.fieldValueOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_data.tenant ",
        dtoStorageDataFilter.tenantCriteria,
        dtoStorageDataFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_data.created_by",
            dtoStorageDataFilter.createdByCriteria,
            dtoStorageDataFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_data.updated_by",
            dtoStorageDataFilter.updatedByCriteria,
            dtoStorageDataFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_data.creation_date",
            dtoStorageDataFilter.creationDateCriteria,
            dtoStorageDataFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_data.update_date",
            dtoStorageDataFilter.updateDateCriteria,
            dtoStorageDataFilter.updateDateOperator);
    return query;
  }

}
