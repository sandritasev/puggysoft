package com.puggysoft.dtos.reservations;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoResScheduleIntervalTimeFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // ID_SCHEDULE
  public String idScheduleCriteria;
  public EnumCompareOperator idScheduleOperator;
  // ID_INTERVAL_TIME
  public String idIntervalTimeCriteria;
  public EnumCompareOperator idIntervalTimeOperator;
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