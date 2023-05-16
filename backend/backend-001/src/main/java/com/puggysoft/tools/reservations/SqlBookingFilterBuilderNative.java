package com.puggysoft.tools.reservations;

import com.puggysoft.dtos.reservations.DtoResBookingFilter;
import com.puggysoft.tools.SqlFilterBuilder;

/** Tool class. */
public final class SqlBookingFilterBuilderNative {

  /** Constructor. */
  private SqlBookingFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoResBookingFilter dtoBookingFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("res_booking.id", dtoBookingFilter.idCriteria,
        dtoBookingFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("id_resource", dtoBookingFilter.idResourceCriteria,
        dtoBookingFilter.idResourceOperator);
    query = query + SqlFilterBuilder.getFilterQuery("id_interval_time", dtoBookingFilter.idIntervalTimeCriteria,
        dtoBookingFilter.idIntervalTimeOperator);
    query = query + SqlFilterBuilder.getFilterQuery("booking_date", dtoBookingFilter.bookingDateCriteria,
        dtoBookingFilter.bookingDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("comments", dtoBookingFilter.commentsCriteria,
        dtoBookingFilter.commentsOperator);
    query = query + SqlFilterBuilder.getFilterQuery("voucher", dtoBookingFilter.voucherCriteria,
        dtoBookingFilter.voucherOperator);
    query = query + SqlFilterBuilder.getFilterQuery("tenant ", dtoBookingFilter.tenantCriteria,
        dtoBookingFilter.tenantOperator);
    query = query + SqlFilterBuilder.getFilterQuery("created_by", dtoBookingFilter.createdByCriteria,
        dtoBookingFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("updated_by", dtoBookingFilter.updatedByCriteria,
        dtoBookingFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("creation_date", dtoBookingFilter.creationDateCriteria,
        dtoBookingFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("update_date", dtoBookingFilter.updateDateCriteria,
        dtoBookingFilter.updateDateOperator);
    return query;
  }

}