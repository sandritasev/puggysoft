package com.puggysoft.dtos.escuela;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoEscuelaCursosFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // NAME
  public String nameCriteria;
  public EnumCompareOperator nameOperator;
  // SHORTNAME
  public String shortNameCriteria;
  public EnumCompareOperator shortNameOperator;
  // GESTION
  public String gestionCriteria;
  public EnumCompareOperator gestionOperator;
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