package com.puggysoft.entities.asistencia;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "asistencia_control")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityAsist extends EntitySuperClass {

  @Column(name = "persona")
  private String persona;
  @Column(name = "detalle")
  private String detalle;
  @Column(name = "tenant")
  private String tenant;

}
