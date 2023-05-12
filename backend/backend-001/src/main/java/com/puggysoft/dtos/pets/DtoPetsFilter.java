package com.puggysoft.dtos.pets;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoPetsFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // NAME
  public String nameCriteria;
  public EnumCompareOperator nameOperator;
  // BIRTH_DATE
  public String birthdateCriteria;
  public EnumCompareOperator birthdateOperator;
  // SEX
  public String sexCriteria;
  public EnumCompareOperator sexOperator;
  // ESPECIE
  public String especieCriteria;
  public EnumCompareOperator especieOperator;
  // RAZA
  public String razaCriteria;
  public EnumCompareOperator razaOperator;
  // COLOR
  public String colorCriteria;
  public EnumCompareOperator colorOperator;
  // DUENO
  public String duenoCriteria;
  public EnumCompareOperator duenoOperator;
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