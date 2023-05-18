package com.puggysoft.dtos.tickets;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoTicketsEventosFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // NOMBRE
  public String nombreCriteria;
  public EnumCompareOperator nombreOperator;
  // SHORT_NAME
  public String shortNameCriteria;
  public EnumCompareOperator shortNameOperator;
  // CANTIDAD_TICKETS
  public String cantidadTicketsCriteria;
  public EnumCompareOperator cantidadTicketsOperator;
  // FECHA_FIN
  public String fechaFinCriteria;
  public EnumCompareOperator fechaFinOperator;
  // FECHA_INICIO
  public String fechaInicioCriteria;
  public EnumCompareOperator fechaInicioOperator;
  // AUX
  public String auxCriteria;
  public EnumCompareOperator auxOperator;
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