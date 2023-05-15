package com.puggysoft.tools.pets;

import com.puggysoft.dtos.pets.DtoPetsHistorialFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlPetsHistorialFilterBuilderNative {

  /** Constructor. */
  private SqlPetsHistorialFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoPetsHistorialFilter dtoPetsHistorialFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoPetsHistorialFilter.idCriteria,
        dtoPetsHistorialFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("diagnostico", dtoPetsHistorialFilter.diagnosticoCriteria,
        dtoPetsHistorialFilter.diagnosticoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tratamiento", dtoPetsHistorialFilter.tratamientoCriteria,
        dtoPetsHistorialFilter.tratamientoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("weight", dtoPetsHistorialFilter.weightCriteria,
        dtoPetsHistorialFilter.weightOperator);
    query = query + SqlFilterBuilder.getFilterQuery("petId", dtoPetsHistorialFilter.petIdCriteria,
        dtoPetsHistorialFilter.petIdOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoPetsHistorialFilter.tenantCriteria,
        dtoPetsHistorialFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoPetsHistorialFilter.createdByCriteria,
        dtoPetsHistorialFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoPetsHistorialFilter.updatedByCriteria,
        dtoPetsHistorialFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoPetsHistorialFilter.creationDateCriteria,
        dtoPetsHistorialFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoPetsHistorialFilter.updateDateCriteria,
        dtoPetsHistorialFilter.updateDateOperator);
    return query;
  }

}
