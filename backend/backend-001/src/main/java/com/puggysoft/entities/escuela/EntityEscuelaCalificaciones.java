package com.puggysoft.entities.escuela;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "escuela_calificaciones")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityEscuelaCalificaciones extends EntitySuperClass {

  @Column(name = "curso")
  private String curso;
  @Column(name = "materia")
  private String materia;
  @Column(name = "estudiante")
  private String estudiante;
  @Column(name = "nota")
  private String nota;
  @Column(name = "nota_valor")
  private String notaValor;
  @Column(name = "tenant")
  private String tenant;

}