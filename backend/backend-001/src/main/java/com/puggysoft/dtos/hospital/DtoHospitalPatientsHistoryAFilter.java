package com.puggysoft.dtos.hospital;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoHospitalPatientsHistoryAFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // PA
  public String presionArterialCriteria;
  public EnumCompareOperator presionArterialOperator;
  // FC
  public String frecuenciaCardiacaCriteria;
  public EnumCompareOperator frecuenciaCardiacaOperator;
  // SO2
  public String saturacionOxigenoCriteria;
  public EnumCompareOperator saturacionOxigenoOperator;
  // ALTURA
  public String alturaCriteria;
  public EnumCompareOperator alturaOperator;
  // WEIGHT
  public String weightCriteria;
  public EnumCompareOperator weightOperator;
  // TEMPERATURA
  public String temperaturaCriteria;
  public EnumCompareOperator temperaturaOperator;
  // ANTECEDENTES
  public String antecedentesCriteria;
  public EnumCompareOperator antecedentesOperator;
  // DIAGNOSTICO
  public String diagnosticoCriteria;
  public EnumCompareOperator diagnosticoOperator;
  // TRATAMIENTO
  public String tratamientoCriteria;
  public EnumCompareOperator tratamientoOperator;
  // PATIENT_USERNAME
  public String patientUsernameCriteria;
  public EnumCompareOperator patientUsernameOperator;
  // TENANT
  public String tenantCriteria;
  public EnumCompareOperator tenantOperator;
  // CREATED BY
  @Size(max = 20)
  public String createdByCriteria;
  public EnumCompareOperator createdByOperator;
  // UPDATED BY
  @Size(max = 20)
  public String updatedByCriteria;
  public EnumCompareOperator updatedByOperator;
  // CREATION DATE
  public String creationDateCriteria;
  public EnumCompareOperator creationDateOperator;
  // UPDATED DATE
  public String updateDateCriteria;
  public EnumCompareOperator updateDateOperator;
}
