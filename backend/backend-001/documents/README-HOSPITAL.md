# java-spring-puggysoft

## HOSPITAL

## HOSPITAL-DOCTORS-DETAILS

### POST CREATE

```
POST localhost:8080/api/v1/hospital-doctors-details
{
  "username": "string",
  "specialization": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/hospital-doctors-details/filter?page=0&size=10
POST localhost:8080/api/v1/hospital-doctors-details/filter/size/{pageSize}
{
  "userNameCriteria": "string",
  "userNameOperator": "TEXT_CONTAINS",
  "specializationCriteria": "string",
  "specializationOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/hospital-doctors-details/{id}
{
  "username": "string",
  "specialization": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
localhost:8080/api/v1/hospital-doctors-details/{id}
```

## HOSPITAL-PATIENTS-DETAILS

### POST CREATE

```
POST localhost:8080/api/v1/hospital-patients-details
{
  "username": "string",
  "susCode": "string",
  "createdBy": "2023-03-11",
  "updatedBy": "2023-05-18"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/hospital-patients-details/filter?page=0&size=10
POST localhost:8080/api/v1/hospital-patients-details/filter/size/{pageSize}
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "susCodeCriteria": "string",
  "susCodeOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/hospital-patients-details/{id}
{
  "username": "string",
  "susCode": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
localhost:8080/api/v1/hospital-patients-details/{id}
```

## HOSPITAL-PATIENTS-HISTORY-A

### POST CREATE

```
POST localhost:8080/api/v1/hospital-patients-history-a
{
  "presionArterial": "string",
  "frecuenciaCardiaca": "string",
  "saturacionOxigeno": "string",
  "altura": "string",
  "weight": "string",
  "temperatura": "string",
  "antecedentes": "string",
  "diagnostico": "string",
  "tratamiento": "string",
  "patientUsername": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/hospital-patients-history-a/filter?page=0&size=10
POST localhost:8080/api/v1/hospital-patients-history-a/filter/size/{pageSize}
{
  "presionArterialCriteria": "string",
  "presionArterialOperator": "TEXT_CONTAINS",
  "frecuenciaCardiacaCriteria": "string",
  "frecuenciaCardiacaOperator": "TEXT_CONTAINS",
  "saturacionOxigenoCriteria": "string",
  "saturacionOxigenoOperator": "TEXT_CONTAINS",
  "alturaCriteria": "string",
  "alturaOperator": "TEXT_CONTAINS",
  "weightCriteria": "string",
  "weightOperator": "TEXT_CONTAINS",
  "temperaturaCriteria": "string",
  "temperaturaOperator": "TEXT_CONTAINS",
  "antecedentesCriteria": "string",
  "antecedentesOperator": "TEXT_CONTAINS",
  "diagnosticoCriteria": "string",
  "diagnosticoOperator": "TEXT_CONTAINS",
  "tratamientoCriteria": "string",
  "tratamientoOperator": "TEXT_CONTAINS",
  "patientUsernameCriteria": "string",
  "patientUsernameOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/hospital-patients-history-a/{id}
{
  "presionArterial": "string",
  "frecuenciaCardiaca": "string",
  "saturacionOxigeno": "string",
  "altura": "string",
  "weight": "string",
  "temperatura": "string",
  "antecedentes": "string",
  "diagnostico": "string",
  "tratamiento": "string",
  "patientUsername": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
localhost:8080/api/v1/hospital-patients-history-a/{id}
```
