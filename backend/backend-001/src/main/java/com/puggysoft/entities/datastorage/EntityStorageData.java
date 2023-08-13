package com.puggysoft.entities.datastorage;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "storage_data")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityStorageData extends EntitySuperClass {

  @Column(name = "record")
  private String record;
  @Column(name = "field")
  private String field;
  @Column(name = "field_value")
  private String fieldValue;
  @Column(name = "tenant")
  private String tenant;

}