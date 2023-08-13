package com.puggysoft.repositories.datastorage;

import com.puggysoft.entities.datastorage.EntityStorageSchemaField;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryStorageSchemaField extends JpaRepository<EntityStorageSchemaField, Long> {

  @Query(value = "SELECT COUNT(*) FROM storage_schema_field;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM storage_schema LIMIT ?1, ?2", nativeQuery = true)
  List<EntityStorageSchemaField> findStorageSchemaFieldByPagination(int off, int size);

}