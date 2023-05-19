package com.puggysoft.dtos.hospital;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoHospitalPatientsDetailsFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // USERNAME
  public String usernameCriteria;
  public EnumCompareOperator usernameOperator;
  // SUS_CODE
  public String susCodeCriteria;
  public EnumCompareOperator susCodeOperator;
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
