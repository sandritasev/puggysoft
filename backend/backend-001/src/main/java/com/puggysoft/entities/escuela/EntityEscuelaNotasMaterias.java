package com.puggysoft.entities.escuela;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "escuela_notas_materias")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityEscuelaNotasMaterias extends EntitySuperClass {

  @Column(name = "materia")
  private String materia;
  @Column(name = "nota")
  private String nota;
  @Column(name = "tenant")
  private String tenant;

}