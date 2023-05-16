# java-spring-puggysoft

## RESERVACIONES

## RESOURCES

### POST CREATE

```
POST localhost:8080/api/v1/reservations-resources
{
  "aux": "string",
  "description": "string"
  "image": "byte[]",
  "name": "string",
  "priceInterval": "number",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/reservations-resources/filter?page=0&size=10
POST localhost:8080/api/v1/reservations-resources/filter/size/{pageSize}
{
  "auxCriteria": "string",
  "auxOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "creationDateCriteria": "string",
  "creationDateOperator": "TEXT_CONTAINS",
  "descriptionCriteria": "string",
  "descriptionOperator": "TEXT_CONTAINS",
  "idCriteria": "string",
  "idOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "priceIntervalCriteria": "string",
  "priceIntervalOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "updateDateCriteria": "string",
  "updateDateOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/reservations-resources/{id}
{
  "id": "number",
  "name": "string",
  "priceInterval": "number",
  "image": "byte[]",
  "description": "string",
  "aux": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
localhost:8080/api/v1/reservations-resources/{id}
```

## SCHEDULE

### POST CREATE

```
POST localhost:8080/api/v1/reservations-schedules
{
  "name": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/reservations-schedules/filter?page=0&size=10
POST localhost:8080/api/v1/reservations-schedules/filter/size/{pageSize}
{
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "creationDateCriteria": "string",
  "creationDateOperator": "TEXT_CONTAINS",
  "idCriteria": "string",
  "idOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "updateDateCriteria": "string",
  "updateDateOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/reservations-schedules/{id}
{
  "id": "number",
  "name": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
localhost:8080/api/v1/reservations-schedules/{id}
```

## RESOURCE-SCHEDULE

### POST CREATE

```
POST localhost:8080/api/v1/reservations-resources-schedules
{

  "idResource": "number",
  "idSchedule": "number",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/reservations-resources-schedules/filter?page=0&size=10
POST localhost:8080/api/v1/reservations-resources-schedules/filter/size/{pageSize}
{
  "createdByCriteria": "string",
  "createdByOperator": TEXT_END_WITH,
  "creationDateCriteria": "string",
  "creationDateOperator": "TEXT_CONTAINS",
  "idCriteria": "string",
  "idOperator": "TEXT_CONTAINS",
  "idResourceCriteria": "string",
  "idResourceOperator": "TEXT_CONTAINS",
  "idScheduleCriteria": "string",
  "idScheduleOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "updateDateCriteria": "string",
  "updateDateOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
localhost:8080/api/v1/reservations-resources-schedules/{id}
```

## INTERVALTIMES

### POST CREATE

```
POST localhost:8080/api/v1/reservations-intervals-times
{
  "name": "string",
  "startTime": "string",
  "endTime": "string"
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/reservations-intervals-times/filter?page=0&size=10
POST localhost:8080/api/v1/reservations-intervals-times/filter/size/{pageSize}
{
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "creationDateCriteria": "string",
  "creationDateOperator": "TEXT_CONTAINS",
  "endTimeCriteria": "string",
  "endTimeOperator": "TEXT_CONTAINS",
  "idCriteria": "string",
  "idOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "startTimeCriteria": "string",
  "startTimeOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "updateDateCriteria": "string",
  "updateDateOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/reservations-intervals-times/{id}
{
  "id": "number",
  "name": "string",
  "startTime": "string",
  "endTime": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
localhost:8080/api/v1/reservations-intervals-times/{id}
```

## SCHEDULEINTERVALTIME

### POST CREATE

```
POST localhost:8080/api/v1/reservations-schedules-intervals-times
{
  "idSchedule": "number",
  "idIntervalTime": "number",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"

}
```

### POST FILTER

```
POST localhost:8080/api/v1/reservations-schedules-intervals-times/filter?page=0&size=10
POST localhost:8080/api/v1/reservations-schedules-intervals-times/filter/size/{pageSize}
{
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "creationDateCriteria": "string",
  "creationDateOperator": "TEXT_CONTAINS",
  "idCriteria": "string",
  "idIntervalTimeCriteria": "string",
  "idIntervalTimeOperator": "TEXT_CONTAINS",
  "idOperator": "TEXT_CONTAINS",
  "idScheduleCriteria": "string",
  "idScheduleOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "updateDateCriteria": "string",
  "updateDateOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
localhost:8080/api/v1/reservations-schedules-intervals-times/{id}
```

## SCHEDULEWORKDAYS

### GET ALL

```
GET localhost:8080/api/v1/reservations-schedules-works-days"
  {
    "idSchedule": "number",
    "workDay": "string"
    "tenant": "string",
    "updatedBy": "string",
    "createdBy": "string"
  }
```

### POST CREATE

```
POST localhost:8080/api/v1/reservations-schedules-works-days
{
  "idSchedule": "number",
  "workDay": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

## BOOKINGS

### POST CREATE

```
POST localhost:8080/api/v1/reservations-bookings
{
  "idResource": "number",
  "idIntervalTime": "number",
  "bookingDate": "string",
  "comments": "string",
  "voucher": "string",
  "status": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/reservations-bookings/filter?page=0&size=10
POST localhost:8080/api/v1/reservations-bookings/filter/size/{pageSize}
{
  "bookingDateCriteria": "string",
  "bookingDateOperator": "TEXT_CONTAINS",
  "commentsCriteria": "string",
  "commentsOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "creationDateCriteria": "string",
  "creationDateOperator": "TEXT_CONTAINS",
  "idCriteria": "string",
  "idIntervalTimeCriteria": "string",
  "idIntervalTimeOperator": "TEXT_CONTAINS",
  "idOperator": "TEXT_CONTAINS",
  "idResourceCriteria": "string",
  "idResourceOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "updateDateCriteria": "string",
  "updateDateOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS",
  "voucherCriteria": "string",
  "voucherOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
localhost:8080/api/v1/reservations-bookings/{id}
```
