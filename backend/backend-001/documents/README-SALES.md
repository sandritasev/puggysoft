# java-spring-puggysoft

## SALES

### POST CREATE

```
POST localhost:8080/api/v1/sales
{
  "client": "string",
  "status": "string",
  "note": "string",
  "totalPrice": 0,
  "customerCash": 0,
  "customerCashChange": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/sales/{id}
{
  "client": "string",
  "status": "string",
  "note": "string",
  "totalPrice": 0,
  "customerCash": 0,
  "customerCashChange": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET-ALL

```
GET localhost:8080/api/v1/sales
{
  "client": "string",
  "status": "string",
  "note": "string",
  "totalPrice": 0,
  "customerCash": 0,
  "customerCashChange": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET BY ID

```
GET localhost:8080/api/v1/sales/{id}
{
  "client": "string",
  "status": "string",
  "note": "string",
  "totalPrice": 0,
  "customerCash": 0,
  "customerCashChange": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER

```
POST localhost:8080/api/v1/sales/filter
{
  "clientCriteria": "string",
  "clientOperator": "TEXT_CONTAINS",
  "statusCriteria": "string",
  "statusOperator": "TEXT_CONTAINS",
  "totalPriceCriteria": "string",
  "totalPriceOperator": "TEXT_CONTAINS",
  "customerCashCriteria": "string",
  "customerCashOperator": "TEXT_CONTAINS",
  "customerCashChangeCriteria": "string",
  "customerCashChangeOperator": "TEXT_CONTAINS",
  "tenantCriteria": "string",
  "tenantOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### GET FILTER SIZE

```
POST localhost:8080/api/v1/sales/filter?page=0&size=10
POST localhost:8080/api/v1/sales/filter/size/{pageSize}
{
  "clientCriteria": "string",
  "clientOperator": "TEXT_CONTAINS",
  "statusCriteria": "string",
  "statusOperator": "TEXT_CONTAINS",
  "totalPriceCriteria": "string",
  "totalPriceOperator": "TEXT_CONTAINS",
  "customerCashCriteria": "string",
  "customerCashOperator": "TEXT_CONTAINS",
  "customerCashChangeCriteria": "string",
  "customerCashChangeOperator": "TEXT_CONTAINS",
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
DELETE localhost:8080/api/v1/sales/{id}
```

## SALES-PRODUCTS

### POST CREATE

```
POST localhost:8080/api/v1/sales-products
{
  "idSale": 0,
  "idProduct": 0,
  "quantity": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### PUT

```
PUT localhost:8080/api/v1/sales-products/{id}
{
  "idSale": 0,
  "idProduct": 0,
  "quantity": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET-ALL

```
GET localhost:8080/api/v1/sales-products
{
  "idSale": 0,
  "idProduct": 0,
  "quantity": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET BY PRODUCT ID

```
GET localhost:8080/api/v1/sales-products/product-id/{id}
{
  "idSale": 0,
  "idProduct": 0,
  "quantity": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET BY SALE ID

```
GET localhost:8080/api/v1/sales-products/sale-id/{id}
{
  "idSale": 0,
  "idProduct": 0,
  "quantity": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/sales-products/{id}
```

## SALES-REPORTS

### PROFIT

```
GET localhost:8080/api/v1/sales-report/profit?year=2012&tenant=EMPRESA_1

```

### PROFIT BY PRODUCT

```
GET localhost:8080/api/v1/sales-report/profit-by-product?year=2012&idProduct=1001&tenant=EMPRESA_1

```

### PROFIT MONTH

```
GET localhost:8080/api/v1/sales-report/profit-month?year=2012&month=10&tenant=EMPRESA_1

```

### PROFIT MONTH BY PRODUCT

```
GET localhost:8080/api/v1/sales-report/profit-month-by-product?year=2012&month=10&idProduct=1001&tenant=EMPRESA_1

```

### QUANTITY

```
GET localhost:8080/api/v1/sales-report/quantity?year=2012&tenant=EMPRESA_1

```

### QUANTITY BY PRODUCT

```
GET localhost:8080/api/v1/sales-report/quantity-by-product?year=2012&idProduct=1001&tenant=EMPRESA_1

```

### QUANTITY MONTH

```
GET localhost:8080/api/v1/sales-report/quantity-month?year=2012&month=10&tenant=EMPRESA_1

```

### QUANTITY MONTH BY PRODUCT

```
GET localhost:8080/api/v1/sales-report/quantity-month-by-product?year=2012&month=10&idProduct=1001&tenant=EMPRESA_1

```

### REVENUE

```
GET localhost:8080/api/v1/sales-report/revenue?year=2012&tenant=EMPRESA_1

```

### REVENUE BY PRODUCT

```
GET localhost:8080/api/v1/sales-report/revenue-by-product?year=2012&idProduct=1001&tenant=EMPRESA_1

```

### REVENUE MONTH

```
GET localhost:8080/api/v1/sales-report/revenue-month?year=2012&month=10&tenant=EMPRESA_1

```

### REVENUE MONTH BY PRODUCT

```
GET localhost:8080/api/v1/sales-report/revenue-month-by-product?year=2012&month=10&idProduct=1001&tenant=EMPRESA_1

```
