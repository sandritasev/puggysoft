# java-spring-puggysoft

## USERS

### USER-LOGIN

```
POST localhost:8080/api/v1/login
{
  "password": "string",
  "username": "string"
}
```

### POST CREATE

```
POST localhost:8080/api/v1/users
{
  "username": "string",
  "password": "string",
  "dni": "string",
  "name": "string",
  "secondName": "string",
  "lastName": "string",
  "secondLastName": "string",
  "birthDate": "string",
  "age": 0,
  "sex": "string",
  "occupation": "string",
  "telephone": "string",
  "address": "string",
  "email": "string",
  "active": true,
  "emailVerified": true,
  "createdBy": "string",
  "updatedBy": "string"
}
```

### POST PICTURE

```
POST localhost:8080/api/v1/users/picture/
```

### PUT

```
PUT localhost:8080/api/v1/users/{id}
{
  "username": "string",
  "password": "string",
  "dni": "string",
  "name": "string",
  "secondName": "string",
  "lastName": "string",
  "secondLastName": "string",
  "birthDate": "string",
  "age": 0,
  "sex": "string",
  "occupation": "string",
  "telephone": "string",
  "address": "string",
  "email": "string",
  "active": true,
  "emailVerified": true,
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET ALL

```
GET localhost:8080/api/v1/users
{
  "username": "string",
  "password": "string",
  "dni": "string",
  "name": "string",
  "secondName": "string",
  "lastName": "string",
  "secondLastName": "string",
  "birthDate": "string",
  "age": 0,
  "sex": "string",
  "occupation": "string",
  "telephone": "string",
  "address": "string",
  "email": "string",
  "active": true,
  "emailVerified": true,
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET BY ID

```
GET localhost:8080/api/v1/users/{id}
{
  "username": "string",
  "password": "string",
  "dni": "string",
  "name": "string",
  "secondName": "string",
  "lastName": "string",
  "secondLastName": "string",
  "birthDate": "string",
  "age": 0,
  "sex": "string",
  "occupation": "string",
  "telephone": "string",
  "address": "string",
  "email": "string",
  "active": true,
  "emailVerified": true,
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER

```
POST localhost:8080/api/v1/users/filter
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "passwordCriteria": "string",
  "passwordOperator": "TEXT_CONTAINS",
  "dniCriteria": "string",
  "dniOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "secondNameCriteria": "string",
  "secondNameOperator": "TEXT_CONTAINS",
  "lastNameCriteria": "string",
  "lastNameOperator": "TEXT_CONTAINS",
  "secondLastNameCriteria": "string",
  "secondLastNameOperator": "TEXT_CONTAINS",
  "birthDateCriteria": "string",
  "birthDateOperator": "TEXT_CONTAINS",
  "ageCriteria": "string",
  "ageOperator": "TEXT_CONTAINS",
  "sexCriteria": "string",
  "sexOperator": "TEXT_CONTAINS",
  "occupationCriteria": "string",
  "occupationOperator": "TEXT_CONTAINS",
  "telephoneCriteria": "string",
  "telephoneOperator": "TEXT_CONTAINS",
  "addressCriteria": "string",
  "addressOperator": "TEXT_CONTAINS",
  "emailCriteria": "string",
  "emailOperator": "TEXT_CONTAINS",
  "activeCriteria": true,
  "activeOperator": "TEXT_CONTAINS",
  "emailVerifiedCriteria": true,
  "emailVerifiedOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### GET FILTER SIZE

```
POST localhost:8080/api/v1/users/filter?page=0&size=10
POST localhost:8080/api/v1/users/filter/size/{pageSize}
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "passwordCriteria": "string",
  "passwordOperator": "TEXT_CONTAINS",
  "dniCriteria": "string",
  "dniOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "secondNameCriteria": "string",
  "secondNameOperator": "TEXT_CONTAINS",
  "lastNameCriteria": "string",
  "lastNameOperator": "TEXT_CONTAINS",
  "secondLastNameCriteria": "string",
  "secondLastNameOperator": "TEXT_CONTAINS",
  "birthDateCriteria": "string",
  "birthDateOperator": "TEXT_CONTAINS",
  "ageCriteria": "string",
  "ageOperator": "TEXT_CONTAINS",
  "sexCriteria": "string",
  "sexOperator": "TEXT_CONTAINS",
  "occupationCriteria": "string",
  "occupationOperator": "TEXT_CONTAINS",
  "telephoneCriteria": "string",
  "telephoneOperator": "TEXT_CONTAINS",
  "addressCriteria": "string",
  "addressOperator": "TEXT_CONTAINS",
  "emailCriteria": "string",
  "emailOperator": "TEXT_CONTAINS",
  "activeCriteria": true,
  "activeOperator": "TEXT_CONTAINS",
  "emailVerifiedCriteria": true,
  "emailVerifiedOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/users/{id}
```

## USERS ROLES

### POST CREATE

```
POST localhost:8080/api/v1/users-roles
{
  "idUser": 0,
  "idRole": 0,
  "tenant": "string",
  "createdBy": "string",
  "updatedBy": "string"
}
```

### GET FILTER WITH ROLES

```
POST localhost:8080/api/v1/users/filter/with-roles
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "passwordCriteria": "string",
  "passwordOperator": "TEXT_CONTAINS",
  "dniCriteria": "string",
  "dniOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "secondNameCriteria": "string",
  "secondNameOperator": "TEXT_CONTAINS",
  "lastNameCriteria": "string",
  "lastNameOperator": "TEXT_CONTAINS",
  "secondLastNameCriteria": "string",
  "secondLastNameOperator": "TEXT_CONTAINS",
  "birthDateCriteria": "string",
  "birthDateOperator": "TEXT_CONTAINS",
  "ageCriteria": "string",
  "ageOperator": "TEXT_CONTAINS",
  "sexCriteria": "string",
  "sexOperator": "TEXT_CONTAINS",
  "occupationCriteria": "string",
  "occupationOperator": "TEXT_CONTAINS",
  "telephoneCriteria": "string",
  "telephoneOperator": "TEXT_CONTAINS",
  "addressCriteria": "string",
  "addressOperator": "TEXT_CONTAINS",
  "emailCriteria": "string",
  "emailOperator": "TEXT_CONTAINS",
  "activeCriteria": true,
  "activeOperator": "TEXT_CONTAINS",
  "emailVerifiedCriteria": true,
  "emailVerifiedOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### GET FILTER WITH ROLES SIZE

```
POST localhost:8080/api/v1/users/filter/with-roles/size
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "passwordCriteria": "string",
  "passwordOperator": "TEXT_CONTAINS",
  "dniCriteria": "string",
  "dniOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "secondNameCriteria": "string",
  "secondNameOperator": "TEXT_CONTAINS",
  "lastNameCriteria": "string",
  "lastNameOperator": "TEXT_CONTAINS",
  "secondLastNameCriteria": "string",
  "secondLastNameOperator": "TEXT_CONTAINS",
  "birthDateCriteria": "string",
  "birthDateOperator": "TEXT_CONTAINS",
  "ageCriteria": "string",
  "ageOperator": "TEXT_CONTAINS",
  "sexCriteria": "string",
  "sexOperator": "TEXT_CONTAINS",
  "occupationCriteria": "string",
  "occupationOperator": "TEXT_CONTAINS",
  "telephoneCriteria": "string",
  "telephoneOperator": "TEXT_CONTAINS",
  "addressCriteria": "string",
  "addressOperator": "TEXT_CONTAINS",
  "emailCriteria": "string",
  "emailOperator": "TEXT_CONTAINS",
  "activeCriteria": true,
  "activeOperator": "TEXT_CONTAINS",
  "emailVerifiedCriteria": true,
  "emailVerifiedOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### GET FILTER WITHOUT ROLES

```
POST localhost:8080/api/v1/users/filter/without-roles
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "passwordCriteria": "string",
  "passwordOperator": "TEXT_CONTAINS",
  "dniCriteria": "string",
  "dniOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "secondNameCriteria": "string",
  "secondNameOperator": "TEXT_CONTAINS",
  "lastNameCriteria": "string",
  "lastNameOperator": "TEXT_CONTAINS",
  "secondLastNameCriteria": "string",
  "secondLastNameOperator": "TEXT_CONTAINS",
  "birthDateCriteria": "string",
  "birthDateOperator": "TEXT_CONTAINS",
  "ageCriteria": "string",
  "ageOperator": "TEXT_CONTAINS",
  "sexCriteria": "string",
  "sexOperator": "TEXT_CONTAINS",
  "occupationCriteria": "string",
  "occupationOperator": "TEXT_CONTAINS",
  "telephoneCriteria": "string",
  "telephoneOperator": "TEXT_CONTAINS",
  "addressCriteria": "string",
  "addressOperator": "TEXT_CONTAINS",
  "emailCriteria": "string",
  "emailOperator": "TEXT_CONTAINS",
  "activeCriteria": true,
  "activeOperator": "TEXT_CONTAINS",
  "emailVerifiedCriteria": true,
  "emailVerifiedOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### GET FILTER WITHOUT ROLES SIZE

```
POST localhost:8080/api/v1/users/filter/without-roles/size
{
  "usernameCriteria": "string",
  "usernameOperator": "TEXT_CONTAINS",
  "passwordCriteria": "string",
  "passwordOperator": "TEXT_CONTAINS",
  "dniCriteria": "string",
  "dniOperator": "TEXT_CONTAINS",
  "nameCriteria": "string",
  "nameOperator": "TEXT_CONTAINS",
  "secondNameCriteria": "string",
  "secondNameOperator": "TEXT_CONTAINS",
  "lastNameCriteria": "string",
  "lastNameOperator": "TEXT_CONTAINS",
  "secondLastNameCriteria": "string",
  "secondLastNameOperator": "TEXT_CONTAINS",
  "birthDateCriteria": "string",
  "birthDateOperator": "TEXT_CONTAINS",
  "ageCriteria": "string",
  "ageOperator": "TEXT_CONTAINS",
  "sexCriteria": "string",
  "sexOperator": "TEXT_CONTAINS",
  "occupationCriteria": "string",
  "occupationOperator": "TEXT_CONTAINS",
  "telephoneCriteria": "string",
  "telephoneOperator": "TEXT_CONTAINS",
  "addressCriteria": "string",
  "addressOperator": "TEXT_CONTAINS",
  "emailCriteria": "string",
  "emailOperator": "TEXT_CONTAINS",
  "activeCriteria": true,
  "activeOperator": "TEXT_CONTAINS",
  "emailVerifiedCriteria": true,
  "emailVerifiedOperator": "TEXT_CONTAINS",
  "createdByCriteria": "string",
  "createdByOperator": "TEXT_CONTAINS",
  "updatedByCriteria": "string",
  "updatedByOperator": "TEXT_CONTAINS"
}
```

### DELETE

```
DELETE localhost:8080/api/v1/users-roles/{id}
```

### PAGINATION SIZE

```
GET localhost:8080/api/v1/users/pagination?page=0&size=10
GET localhost:8080/api/v1/users/pagination/size/{pageSize}
```
