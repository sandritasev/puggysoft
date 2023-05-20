package com.puggysoft.tools.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetailsFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlHospitalPatientsDetailsFilterBuilderNative {

  /** Constructor. */
  private SqlHospitalPatientsDetailsFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoHospitalPatientsDetailsFilter dtoHospitalPatientsDetailsFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoHospitalPatientsDetailsFilter.idCriteria,
        dtoHospitalPatientsDetailsFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("username", dtoHospitalPatientsDetailsFilter.usernameCriteria,
        dtoHospitalPatientsDetailsFilter.usernameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("sus_code", dtoHospitalPatientsDetailsFilter.susCodeCriteria,
        dtoHospitalPatientsDetailsFilter.susCodeOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoHospitalPatientsDetailsFilter.createdByCriteria,
        dtoHospitalPatientsDetailsFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoHospitalPatientsDetailsFilter.updatedByCriteria,
        dtoHospitalPatientsDetailsFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date",
        dtoHospitalPatientsDetailsFilter.creationDateCriteria,
        dtoHospitalPatientsDetailsFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoHospitalPatientsDetailsFilter.updateDateCriteria,
        dtoHospitalPatientsDetailsFilter.updateDateOperator);
    return query;
  }

}
