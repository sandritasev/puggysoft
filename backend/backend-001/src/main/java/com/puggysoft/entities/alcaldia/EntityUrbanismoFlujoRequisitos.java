package com.puggysoft.entities.alcaldia;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "alc_urb_tramite_flujo_requisitos")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityUrbanismoFlujoRequisitos extends EntitySuperClass {

  @Column(name = "id_tramite_flujo")
  private String idTramiteFlujo;
  @Column(name = "requisito_nombre_corto")
  private String requisitoNombreCorto;
  @Column(name = "estado")
  private String estado;
  @Column(name = "archivo_requisito")
  private String archivoRequisito;
  @Column(name = "tenant")
  private String tenant;

}