package com.puggysoft.repositories.datastorage;

import com.puggysoft.entities.datastorage.EntityStorageSchema;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryStorageSchema extends JpaRepository<EntityStorageSchema, Long> {

  @Query(value = "SELECT COUNT(*) FROM storage_schema;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM storage_schema LIMIT ?1, ?2", nativeQuery = true)
  List<EntityStorageSchema> findStorageSchemaByPagination(int off, int size);

}