package com.puggysoft.dtos.tickets;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.tickets.EntityTickets;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoTickets extends DtoSuperClass {
  @NotNull
  private String evento;
  @NotNull
  private String uuid;
  @NotNull
  private String used;
  @NotNull
  private String cliente;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityTickets dtoToEntity() {
    EntityTickets entity = new EntityTickets();
    entity.setId(id);
    entity.setEvento(evento);
    entity.setUuid(uuid);
    entity.setUsed(used);
    entity.setCliente(cliente);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoTickets entityToDto(EntityTickets entity) {
    DtoTickets dto = new DtoTickets();
    dto.setId(entity.getId());
    dto.setEvento(entity.getEvento());
    dto.setUuid(entity.getUuid());
    dto.setUsed(entity.getUsed());
    dto.setCliente(entity.getCliente());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
