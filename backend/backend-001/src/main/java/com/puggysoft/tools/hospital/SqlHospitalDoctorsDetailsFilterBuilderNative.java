package com.puggysoft.tools.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetailsFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlHospitalDoctorsDetailsFilterBuilderNative {

  /** Constructor. */
  private SqlHospitalDoctorsDetailsFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoHospitalDoctorsDetailsFilter dtoHospitalDoctorsDetailsFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoHospitalDoctorsDetailsFilter.idCriteria,
        dtoHospitalDoctorsDetailsFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("username", dtoHospitalDoctorsDetailsFilter.userNameCriteria,
        dtoHospitalDoctorsDetailsFilter.userNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("birthdate", dtoHospitalDoctorsDetailsFilter.specializationCriteria,
        dtoHospitalDoctorsDetailsFilter.specializationOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoHospitalDoctorsDetailsFilter.createdByCriteria,
        dtoHospitalDoctorsDetailsFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoHospitalDoctorsDetailsFilter.updatedByCriteria,
        dtoHospitalDoctorsDetailsFilter.updatedByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("creation_date", dtoHospitalDoctorsDetailsFilter.creationDateCriteria,
            dtoHospitalDoctorsDetailsFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoHospitalDoctorsDetailsFilter.updateDateCriteria,
        dtoHospitalDoctorsDetailsFilter.updateDateOperator);
    return query;
  }

}
