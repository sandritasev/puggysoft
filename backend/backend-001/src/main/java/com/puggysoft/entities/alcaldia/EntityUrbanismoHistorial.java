package com.puggysoft.entities.alcaldia;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "alc_urb_historial")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityUrbanismoHistorial extends EntitySuperClass {

  @Column(name = "id_tramite_flujo")
  private String idTramiteFlujo;
  @Column(name = "username")
  private String username;
  @Column(name = "estado_anterior")
  private String estadoAnterior;
  @Column(name = "estado_nuevo")
  private String estadoNuevo;
  @Column(name = "tenant")
  private String tenant;
  @Column(name = "comments")
  private String comments;

}