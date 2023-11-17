package com.puggysoft.dtos.datastorage;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoStorageDataFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // record
  public String recordCriteria;
  public EnumCompareOperator recordOperator;
  // field
  public String fieldCriteria;
  public EnumCompareOperator fieldOperator;
  // fieldValue
  public String fieldValueCriteria;
  public EnumCompareOperator fieldValueOperator;
  // schema
  public String schemaCriteria;
  public EnumCompareOperator schemaOperator;
  // TENANT
  public String tenantCriteria;
  public EnumCompareOperator tenantOperator;
  // CREATED BY
  @Size(max = 30)
  public String createdByCriteria;
  public EnumCompareOperator createdByOperator;
  // UPDATED BY
  @Size(max = 30)
  public String updatedByCriteria;
  public EnumCompareOperator updatedByOperator;
  // CREATION DATE
  public String creationDateCriteria;
  public EnumCompareOperator creationDateOperator;
  // UPDATED DATE
  public String updateDateCriteria;
  public EnumCompareOperator updateDateOperator;
}