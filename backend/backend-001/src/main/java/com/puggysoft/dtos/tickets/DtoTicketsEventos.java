package com.puggysoft.dtos.tickets;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.tickets.EntityTicketsEventos;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoTicketsEventos extends DtoSuperClass {
  @NotNull
  private String nombre;
  @NotNull
  private String shortName;
  @NotNull
  private String cantidadTickets;
  @NotNull
  private String fechaFin;
  @NotNull
  private String fechaInicio;
  @NotNull
  private String aux;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityTicketsEventos dtoToEntity() {
    EntityTicketsEventos entity = new EntityTicketsEventos();
    entity.setId(id);
    entity.setNombre(nombre);
    entity.setShortName(shortName);
    entity.setCantidadTickets(cantidadTickets);
    entity.setFechaFin(fechaFin);
    entity.setFechaInicio(fechaInicio);
    entity.setAux(aux);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoTicketsEventos entityToDto(EntityTicketsEventos entity) {
    DtoTicketsEventos dto = new DtoTicketsEventos();
    dto.setId(entity.getId());
    dto.setNombre(entity.getNombre());
    dto.setShortName(entity.getShortName());
    dto.setCantidadTickets(entity.getCantidadTickets());
    dto.setFechaFin(entity.getFechaFin());
    dto.setFechaInicio(entity.getFechaInicio());
    dto.setAux(entity.getAux());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}