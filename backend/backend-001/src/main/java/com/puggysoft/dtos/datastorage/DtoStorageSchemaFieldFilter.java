package com.puggysoft.dtos.datastorage;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoStorageSchemaFieldFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // schema
  public String schemaCriteria;
  public EnumCompareOperator schemaOperator;
  // field
  public String fieldCriteria;
  public EnumCompareOperator fieldOperator;
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