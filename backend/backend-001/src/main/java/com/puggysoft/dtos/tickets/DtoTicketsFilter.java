package com.puggysoft.dtos.tickets;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoTicketsFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // EVENTO
  public String eventoCriteria;
  public EnumCompareOperator eventoOperator;
  // UUID
  public String uuidCriteria;
  public EnumCompareOperator uuidOperator;
  // USED
  public String usedCriteria;
  public EnumCompareOperator usedOperator;
  // CLIENTE
  public String clienteCriteria;
  public EnumCompareOperator clienteOperator;
  // TENANT
  public String tenantCriteria;
  public EnumCompareOperator tenantOperator;
  // CREATED BY
  @Size(max = 20)
  public String createdByCriteria;
  public EnumCompareOperator createdByOperator;
  // UPDATED BY
  @Size(max = 20)
  public String updatedByCriteria;
  public EnumCompareOperator updatedByOperator;
  // CREATION DATE
  public String creationDateCriteria;
  public EnumCompareOperator creationDateOperator;
  // UPDATED DATE
  public String updateDateCriteria;
  public EnumCompareOperator updateDateOperator;
}
