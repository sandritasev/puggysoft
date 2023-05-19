package com.puggysoft.tools.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryAFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlHospitalPatientsHistoryAFilterBuilderNative {

  /** Constructor. */
  private SqlHospitalPatientsHistoryAFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoHospitalPatientsHistoryAFilter dtoHospitalPatientsHistoryAFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("id", dtoHospitalPatientsHistoryAFilter.idCriteria,
        dtoHospitalPatientsHistoryAFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("pa", dtoHospitalPatientsHistoryAFilter.presionArterialCriteria,
        dtoHospitalPatientsHistoryAFilter.presionArterialOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("fc", dtoHospitalPatientsHistoryAFilter.frecuenciaCardiacaCriteria,
            dtoHospitalPatientsHistoryAFilter.frecuenciaCardiacaOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("so2", dtoHospitalPatientsHistoryAFilter.saturacionOxigenoCriteria,
            dtoHospitalPatientsHistoryAFilter.saturacionOxigenoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("altura", dtoHospitalPatientsHistoryAFilter.alturaCriteria,
        dtoHospitalPatientsHistoryAFilter.alturaOperator);
    query = query + SqlFilterBuilder.getFilterQuery("weight", dtoHospitalPatientsHistoryAFilter.weightCriteria,
        dtoHospitalPatientsHistoryAFilter.weightOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("temperatura", dtoHospitalPatientsHistoryAFilter.temperaturaCriteria,
            dtoHospitalPatientsHistoryAFilter.temperaturaOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("antecedentes",
            dtoHospitalPatientsHistoryAFilter.antecedentesCriteria,
            dtoHospitalPatientsHistoryAFilter.antecedentesOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("diagnostico", dtoHospitalPatientsHistoryAFilter.diagnosticoCriteria,
            dtoHospitalPatientsHistoryAFilter.diagnosticoOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("tratamiento", dtoHospitalPatientsHistoryAFilter.tratamientoCriteria,
            dtoHospitalPatientsHistoryAFilter.tratamientoOperator);
    query = query + SqlFilterBuilder.getFilterQuery("patient_username",
        dtoHospitalPatientsHistoryAFilter.patientUsernameCriteria,
        dtoHospitalPatientsHistoryAFilter.patientUsernameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant", dtoHospitalPatientsHistoryAFilter.tenantCriteria,
        dtoHospitalPatientsHistoryAFilter.tenantOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("created_by", dtoHospitalPatientsHistoryAFilter.createdByCriteria,
            dtoHospitalPatientsHistoryAFilter.createdByOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("updated_by", dtoHospitalPatientsHistoryAFilter.updatedByCriteria,
            dtoHospitalPatientsHistoryAFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date",
        dtoHospitalPatientsHistoryAFilter.creationDateCriteria,
        dtoHospitalPatientsHistoryAFilter.creationDateOperator);
    query = query
        + SqlFilterBuilder.getFilterQuery("update_date", dtoHospitalPatientsHistoryAFilter.updateDateCriteria,
            dtoHospitalPatientsHistoryAFilter.updateDateOperator);
    return query;
  }

}
