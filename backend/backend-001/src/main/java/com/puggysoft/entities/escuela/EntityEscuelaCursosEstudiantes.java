package com.puggysoft.entities.escuela;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "escuela_cursos_estudiantes")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityEscuelaCursosEstudiantes extends EntitySuperClass {

  @Column(name = "curso")
  private String curso;
  @Column(name = "estudiante")
  private String estudiante;
  @Column(name = "tenant")
  private String tenant;

}