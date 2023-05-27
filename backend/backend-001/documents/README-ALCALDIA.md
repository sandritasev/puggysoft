# java-spring-puggysoft

## ALCALDIA

## ALCALDIA RECURSOS MUNICIPALES

### POST CREATE

```
POST localhost:8080/api/v1/alcaldia-recursos-municipales
{
  "codigo": "string",
  "name": "string",
  "precio": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/alcaldia-recursos-municipales/{id}
{
  "codigo": "string",
  "name": "string",
  "precio": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### FILTER

```
POST localhost:8080/api/v1/alcaldia-recursos-municipales/filter?page=0&size=10
POST localhost:8080/api/v1/alcaldia-recursos-municipales/filter/size/{pageSize}
{
  "codigoCriteria": "string",
  "codigoOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "precioCriteria": "string",
  "precioOperator": "TEXT_CONTAINS",
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
DELETE localhost:8080/api/v1/alcaldia-recursos-municipales/{id}
```

## ALCALDIA RECURSOS MUNICIPALES VENTA

### POST CREATE

```
POST localhost:8080/api/v1/alcaldia-recursos-municipales-venta
{
  "clienteNombre": "string",
  "clienteCiNit": "string",
  "direccion": "string",
  "nota": "string",
  "ventaStatus": "string",
  "ventaPrecioTotal": "string",
  "clienteDinero": "string",
  "clienteCambio": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/alcaldia-recursos-municipales-venta/{id}
{
  "clienteNombre": "string",
  "clienteCiNit": "string",
  "direccion": "string",
  "nota": "string",
  "ventaStatus": "string",
  "ventaPrecioTotal": "string",
  "clienteDinero": "string",
  "clienteCambio": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### FILTER

```
POST localhost:8080/api/v1/alcaldia-recursos-municipales-venta/filter?page=0&size=10
POST localhost:8080/api/v1/alcaldia-recursos-municipales-venta/filter/size/{pageSize}
{
  "clienteNombreCriteria": "string",
  "clienteNombreOperator": "TEXT_CONTAINS",
  "clienteCiNitCriteria": "string",
  "clienteCiNitOperator": "TEXT_CONTAINS",
  "direccionCriteria": "string",
  "direccionOperator": "TEXT_CONTAINS",
  "notaCriteria": "string",
  "notaOperator": "TEXT_CONTAINS",
  "ventaStatusCriteria": "string",
  "ventaStatusOperator": "TEXT_CONTAINS",
  "ventaPrecioTotalCriteria": "string",
  "ventaPrecioTotalOperator": "TEXT_CONTAINS",
  "clienteDineroCriteria": "string",
  "clienteDineroOperator": "TEXT_CONTAINS",
  "clienteCambioCriteria": "string",
  "clienteCambioOperator": "TEXT_CONTAINS",
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
DELETE localhost:8080/api/v1/alcaldia-recursos-municipales-venta/{id}
```

## ALCALDIA RECURSOS MUNICIPALES VENTA DETALLE

### POST CREATE

```
POST localhost:8080/api/v1/alcaldia-recursos-municipales-venta-detalle
{
  "recuersoMunicipalCodigo": "string",
  "idVenta": "string",
  "precioUnidad": "string",
  "cantidad": "string",
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/alcaldia-recursos-municipales-venta-detalle/{id}
```
