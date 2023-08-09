package com.puggysoft.dtos.alcaldia;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoRegulaLotesFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // NOMBRE CLIENTE
  public String nombreClienteCriteria;
  public EnumCompareOperator nombreClienteOperator;
  // CI CLIENTE
  public String ciClienteCriteria;
  public EnumCompareOperator ciClienteOperator;
  // NUMERO INMUEBLE
  public String numeroInmuebleCriteria;
  public EnumCompareOperator numeroInmuebleOperator;
  // COMPROBANTE PAGO
  public String comprobantePagoCriteria;
  public EnumCompareOperator comprobantePagoOperator;
  // MONTO
  public String montoCriteria;
  public EnumCompareOperator montoOperator;
  // TENANT
  public String tenantCriteria;
  public EnumCompareOperator tenantOperator;
  // CREATED BY
  @Size(max = 30)
  public String createdByCriteria;
  public EnumCompareOperator createdByOperator;
  // UPDATED BY
  @Size(max = 30)
  public String updatedByCriteria;
  public EnumCompareOperator updatedByOperator;
  // CREATION DATE
  public String creationDateCriteria;
  public EnumCompareOperator creationDateOperator;
  // UPDATED DATE
  public String updateDateCriteria;
  public EnumCompareOperator updateDateOperator;
}