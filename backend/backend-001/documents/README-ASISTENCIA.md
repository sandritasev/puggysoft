# java-spring-puggysoft

## FACTURAS

### GET

```
GET localhost:8080/api/v1/asist-control/{id}"
{
  "createdBy": "admin",
  "creationDate": "2023-05-09T14:58:00.139Z",
  "detalle": "prueba2",
  "persona": "cluza",
  "tenant": "EMPRESA_1",
  "updateDate": "2023-05-09T14:58:00.139Z",
  "updatedBy": "string"
}
```

## POST CREATE

```
POST localhost:8080/api/v1/asist-control
{
    "createdBy": "SysControlAsistenciaAdmin",
    "creationDate": "2023-05-09",
    "detalle": "ASISTENCIA",
    "persona": "MARIA_MORENO",
    "tenant": "EMPRESA_1",
    "updatedBy": "SysControlAsistenciaAdmin"
}
```

## POST FILTER

```
POST localhost:8080/api/v1/asist-control/filter?page=0&size=10
POST localhost:8080/api/v1/asist-control/filter/size/{pageSize}
{
    "idCriteria": "7",
    "idOperator": "TEXT_CONTAINS",
    "personaCriteria": "8",
    "personaOperator": "TEXT_END_WITH",
    "detalleCriteria":"6",
    "detalleOperator":"TEXT_EQUALS",
    "tenantCriteria": "34",
    "tenantOperator": "TEXT_CONTAINS"
}
```

## PUT

```
PUT localhost:8080/api/v1/asist-control/{id}
{
   "createdBy": "SysControlAsistenciaAdmin",
   "creationDate": "2023-05-09",
   "detalle": "ASISTENCIA",
   "persona": "MARIA_MORENO",
   "tenant": "EMPRESA_1",
   "updateDate": "2023-05-09",
   "updatedBy": "SysControlAsistenciaAdmin"
}
```

## DELETE

```
localhost:8080/api/v1/asist-control/{id}
```
