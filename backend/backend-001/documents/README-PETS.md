# java-spring-puggysoft

## PETS

## PETS-PETS

### GET

```
GET localhost:8080/api/v1/pets/{id}"
{
  "birth_date": "2023-05-12",
  "color": "blanco",
  "createdBy": "SysPetsAdmin",
  "creationDate": "2023-05-12",
  "dueno": "MARCELA_RUEDA",
  "especie": "canino"
  "name": "balto",
  "raza": "husky",
  "sex": "masculino",
  "tenant": "EMPRESA_1"
}
```

### POST CREATE

```
POST localhost:8080/api/v1/pets
{
  "birth_date": "2023-05-12",
  "color": "cafe",
  "createdBy": "SysPetsAdmin",
  "creationDate": "2023-05-12",
  "dueno": "MARCELA_RUEDA",
  "especie": "canino"
  "name": "Verdell",
  "raza": "pug",
  "sex": "masculino",
  "tenant": "EMPRESA_1"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/pets/filter?page=0&size=10
POST localhost:8080/api/v1/pets/filter/size/{pageSize}
{
    "idCriteria": "7",
    "idOperator": "TEXT_CONTAINS",
    "nameCriteria": "8",
    "nameOperator": "TEXT_END_WITH",
    "birthdateCriteria":"6",
    "birthdateOperator":"TEXT_EQUALS",
    "sexCriteria": "34",
    "sexOperator": "TEXT_CONTAINS",
    "especieCriteria": "34",
    "especieOperator": "TEXT_CONTAINS",
    "razaCriteria": "34",
    "razaOperator": "TEXT_CONTAINS",
    "colorCriteria": "34",
    "colorOperator": "TEXT_CONTAINS",
    "duenoCriteria": "34",
    "duenoOperator": "TEXT_CONTAINS",
    "tenantCriteria": "34",
    "tenantOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/pets/{id}
{
  "birth_date": "2023-05-12",
  "color": "blanco",
  "createdBy": "SysPetsAdmin",
  "creationDate": "2023-05-12",
  "dueno": "MARCELA_RUEDA",
  "especie": "felino"
  "name": "Rosita",
  "raza": "caniche",
  "sex": "femenino",
  "tenant": "EMPRESA_1"
}
```

### DELETE

```
localhost:8080/api/v1/pets/{id}
```

## PETS-HISTORIAL

### GET

```
GET localhost:8080/api/v1/pets-historial/{id}"
{
  "createdBy": "SysPetsAdmin",
  "creationDate": "2023-05-12",
  "diagnostico": "Bajopeso"
  "pet_id": "string",
  "tenant": "EMPRESA_1",
  "tratamiento": "vitaminas",
  "weight": "12"
}
```

### POST CREATE

```
POST localhost:8080/api/v1/pets-historial
{
  "createdBy": "SysPetsAdmin",
  "creationDate": "2023-05-12",
  "diagnostico": "rabia"
  "pet_id": "string",
  "tenant": "EMPRESA_1",
  "tratamiento": "vacuna"
  "weight": "34"
}
```

### POST FILTER

```
POST localhost:8080/api/v1/pets-historial/filter?page=0&size=10
POST localhost:8080/api/v1/pets-historial/filter/size/{pageSize}
{
    "idCriteria": "7",
    "idOperator": "TEXT_CONTAINS",
    "diagnosticoCriteria": "8",
    "diagnosticoOperator": "TEXT_END_WITH",
    "tratamientoCriteria":"6",
    "tratamientoOperator":"TEXT_EQUALS",
    "weightCriteria":"6",
    "weightOperator":"TEXT_EQUALS",
    "petIdCriteria":"6",
    "petIdOperator":"TEXT_EQUALS",
    "tenantCriteria": "34",
    "tenantOperator": "TEXT_CONTAINS"
}
```

### PUT

```
PUT localhost:8080/api/v1/pets-historial/{id}
{
  "createdBy": "SysPetsAdmin",
  "creationDate": "2023-05-12",
  "diagnostico": "moquillo"
  "pet_id": "string",
  "tenant": "EMPRESA_1",
  "tratamiento": "Vacuna",
  "updateDate": "2023-05-12"
  "weight": "20"
}
```

### DELETE

```
localhost:8080/api/v1/pets-historial/{id}
```
