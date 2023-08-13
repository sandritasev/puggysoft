package com.puggysoft.tools.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecordFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlStorageRecordFilterBuilderNative {

  /** Constructor. */
  private SqlStorageRecordFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoStorageRecordFilter dtoStorageRecordFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("storage_record.id",
        dtoStorageRecordFilter.idCriteria,
        dtoStorageRecordFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_record.short_name",
        dtoStorageRecordFilter.shortNameCriteria,
        dtoStorageRecordFilter.shortNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_record.schema_",
        dtoStorageRecordFilter.schemaCriteria,
        dtoStorageRecordFilter.schemaOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_record.aux",
        dtoStorageRecordFilter.auxCriteria,
        dtoStorageRecordFilter.auxOperator);
    query = query + SqlFilterBuilder.getFilterQuery("storage_record.tenant ",
        dtoStorageRecordFilter.tenantCriteria,
        dtoStorageRecordFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_record.created_by",
            dtoStorageRecordFilter.createdByCriteria,
            dtoStorageRecordFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_record.updated_by",
            dtoStorageRecordFilter.updatedByCriteria,
            dtoStorageRecordFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_record.creation_date",
            dtoStorageRecordFilter.creationDateCriteria,
            dtoStorageRecordFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("storage_record.update_date",
            dtoStorageRecordFilter.updateDateCriteria,
            dtoStorageRecordFilter.updateDateOperator);
    return query;
  }

}
