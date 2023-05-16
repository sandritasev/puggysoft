package com.puggysoft.dtos.reservations;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoResBookingFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // ID_RESOURCE
  public String idResourceCriteria;
  public EnumCompareOperator idResourceOperator;
  // ID_INTERVAL_TIME
  public String idIntervalTimeCriteria;
  public EnumCompareOperator idIntervalTimeOperator;
  // BOOKING_DATE
  public String bookingDateCriteria;
  public EnumCompareOperator bookingDateOperator;
  // COMMENTS
  public String commentsCriteria;
  public EnumCompareOperator commentsOperator;
  // VOUCHER
  public String voucherCriteria;
  public EnumCompareOperator voucherOperator;
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