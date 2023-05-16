package com.puggysoft.dtos.reservations;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoResIntervalTimeFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // NAME
  public String nameCriteria;
  public EnumCompareOperator nameOperator;
  // START_TIME
  public String startTimeCriteria;
  public EnumCompareOperator startTimeOperator;
  // END_TIME
  public String endTimeCriteria;
  public EnumCompareOperator endTimeOperator;
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
