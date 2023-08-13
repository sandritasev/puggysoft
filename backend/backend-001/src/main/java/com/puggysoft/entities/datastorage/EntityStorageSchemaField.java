package com.puggysoft.entities.datastorage;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "storage_schema_field")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityStorageSchemaField extends EntitySuperClass {

  @Column(name = "schema_")
  private String schema;
  @Column(name = "field")
  private String field;
  @Column(name = "tenant")
  private String tenant;

}