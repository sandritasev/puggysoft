package com.puggysoft.tools.pets;

import com.puggysoft.dtos.pets.DtoPetsFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlPetsFilterBuilderNative {

  /** Constructor. */
  private SqlPetsFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoPetsFilter dtoPetsFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoPetsFilter.idCriteria,
        dtoPetsFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("name", dtoPetsFilter.nameCriteria,
        dtoPetsFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("birthdate", dtoPetsFilter.birthdateCriteria,
        dtoPetsFilter.birthdateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("sex", dtoPetsFilter.sexCriteria,
        dtoPetsFilter.sexOperator);
    query = query + SqlFilterBuilder.getFilterQuery("especie", dtoPetsFilter.especieCriteria,
        dtoPetsFilter.especieOperator);
    query = query + SqlFilterBuilder.getFilterQuery("raza", dtoPetsFilter.razaCriteria,
        dtoPetsFilter.razaOperator);
    query = query + SqlFilterBuilder.getFilterQuery("color", dtoPetsFilter.colorCriteria,
        dtoPetsFilter.colorOperator);
    query = query + SqlFilterBuilder.getFilterQuery("dueno", dtoPetsFilter.duenoCriteria,
        dtoPetsFilter.duenoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoPetsFilter.tenantCriteria,
        dtoPetsFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoPetsFilter.createdByCriteria,
        dtoPetsFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoPetsFilter.updatedByCriteria,
        dtoPetsFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoPetsFilter.creationDateCriteria,
        dtoPetsFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoPetsFilter.updateDateCriteria,
        dtoPetsFilter.updateDateOperator);
    return query;
  }

}
