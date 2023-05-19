package com.puggysoft.tools.users;

import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.tools.SqlFilterBuilder;
import com.puggysoft.tools.SqlFilterBuilderBoolean;


/** Tool class.*/
public final class SqlUserFilterBuilderNative {

  /** Constructor.*/
  private SqlUserFilterBuilderNative() {
  }

  /** build filter query method. */
  public static String build(DtoUserFilter dtoUserFilter) {
    String query = "";
    query = query + SqlFilterBuilder.getFilterQuery("users.id", dtoUserFilter.idCriteria, dtoUserFilter.idOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.username", dtoUserFilter.usernameCriteria, dtoUserFilter.usernameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.password", dtoUserFilter.passwordCriteria, dtoUserFilter.passwordOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.dni", dtoUserFilter.dniCriteria, dtoUserFilter.dniOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.name", dtoUserFilter.nameCriteria, dtoUserFilter.nameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.second_name", dtoUserFilter.secondNameCriteria, dtoUserFilter.secondNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.last_name", dtoUserFilter.lastNameCriteria, dtoUserFilter.lastNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.second_last_name", dtoUserFilter.secondLastNameCriteria, dtoUserFilter.secondLastNameOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.birth_date", dtoUserFilter.birthDateCriteria, dtoUserFilter.birthDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.age", dtoUserFilter.ageCriteria, dtoUserFilter.ageOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.sex", dtoUserFilter.sexCriteria, dtoUserFilter.sexOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.occupation", dtoUserFilter.occupationCriteria, dtoUserFilter.occupationOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.telephone", dtoUserFilter.telephoneCriteria, dtoUserFilter.telephoneOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.address", dtoUserFilter.addressCriteria, dtoUserFilter.addressOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.email", dtoUserFilter.emailCriteria, dtoUserFilter.emailOperator);
    query = query + SqlFilterBuilderBoolean.getFilterQuery("users.active", dtoUserFilter.activeCriteria, dtoUserFilter.activeOperator);
    query = query + SqlFilterBuilderBoolean.getFilterQuery("users.email_verified", dtoUserFilter.emailVerifiedCriteria, dtoUserFilter.emailVerifiedOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.created_by", dtoUserFilter.createdByCriteria, dtoUserFilter.createdByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.updated_by", dtoUserFilter.updatedByCriteria, dtoUserFilter.updatedByOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.creation_date", dtoUserFilter.creationDateCriteria, dtoUserFilter.creationDateOperator);
    query = query + SqlFilterBuilder.getFilterQuery("users.update_date", dtoUserFilter.updateDateCriteria, dtoUserFilter.updateDateOperator);
    return query;
  }

}