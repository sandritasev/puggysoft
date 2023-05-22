# java-spring-puggysoft

## ESCUELA

## ESCUELA CURSOS

### POST CREATE

```
POST localhost:8080/api/v1/escuela-cursos
{
  "name": "string",
  "shortName": "string",
  "gestion": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/escuela-cursos/{id}
{
  "name": "string",
  "shortName": "string",
  "gestion": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER

```
POST localhost:8080/api/v1/escuela-cursos/filter
{
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "shortNameCriteria": "string",
  "shortNameOperator": "TEXT_CONTAINS",
  "gestionCriteria": "string",
  "gestionOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-cursos/{id}
```

## ESCUELA MATERIAS

### POST CREATE

```
POST localhost:8080/api/v1/escuela-materias
{
  "name": "string",
  "shortName": "string",
  "notaMaxima": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/escuela-materias/{id}
{
  "name": "string",
  "shortName": "string",
  "notaMaxima": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER

```
POST localhost:8080/api/v1/escuela-materias/filter
{
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "shortNameCriteria": "string",
  "shortNameOperator": "TEXT_CONTAINS",
  "notaMaximaCriteria": "string",
  "notaMaximaOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-materias/{id}
```

## ESCUELA NOTAS

### POST CREATE

```
POST localhost:8080/api/v1/escuela-notas
{
  "name": "string",
  "shortName": "string",
  "porcentaje": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/escuela-notas/{id}
{
  "name": "string",
  "shortName": "string",
  "porcentaje": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER

```
POST localhost:8080/api/v1/escuela-notas/filter
{
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "shortNameCriteria": "string",
  "shortNameOperator": "TEXT_CONTAINS",
  "porcentajeCriteria": "string",
  "porcentajeOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-notas/{id}
```

## ESCUELA CURSOS MATERIAS

### POST CREATE

```
POST localhost:8080/api/v1/escuela-cursos-materias
{
  "curso": "string",
  "materia": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-cursos-materias/{id}
```

## ESCUELA NOTAS MATERIAS

### POST CREATE

```
POST localhost:8080/api/v1/escuela-notas-materias
{
  "materia": "string",
  "nota": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-notas-materias/{id}
```

## ESCUELA CURSOS ESTUDIANTES

### POST CREATE

```
POST localhost:8080/api/v1/escuela-cursos-estudiantes
{
  "curso": "string",
  "estudiante": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-cursos-estudiantes/{id}
```

## ESCUELA CALIFICACIONES

### POST CREATE

```
POST localhost:8080/api/v1/escuela-calificaciones
{
  "curso": "string",
  "materia": "string",
  "estudiante": "string",
  "nota": "string",
  "notaValor": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER

```
POST localhost:8080/api/v1/escuela-calificaciones/filter
{
  "cursoCriteria": "string",
  "cursoOperator": "TEXT_CONTAINS",
  "materiaCriteria": "string",
  "materiaOperator": "TEXT_CONTAINS",
  "estudianteCriteria": "string",
  "estudianteOperator": "TEXT_CONTAINS",
  "notaCriteria": "string",
  "notaOperator": "TEXT_CONTAINS",
  "notaValorCriteria": "string",
  "notaValorOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/escuela-calificaciones/{id}
```
