package com.puggysoft.dtos.escuela;

import com.puggysoft.models.EnumCompareOperator;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Class.
 */
@Data
public class DtoEscuelaCalificacionesFilter {

  // ID
  public String idCriteria;
  public EnumCompareOperator idOperator;
  // CURSO
  public String cursoCriteria;
  public EnumCompareOperator cursoOperator;
  // MATERIA
  public String materiaCriteria;
  public EnumCompareOperator materiaOperator;
  // ESTUDIANTE
  public String estudianteCriteria;
  public EnumCompareOperator estudianteOperator;
  // NOTA
  public String notaCriteria;
  public EnumCompareOperator notaOperator;
  // NOTA_VALOR
  public String notaValorCriteria;
  public EnumCompareOperator notaValorOperator;
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