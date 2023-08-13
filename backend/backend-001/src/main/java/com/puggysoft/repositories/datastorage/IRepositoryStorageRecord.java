package com.puggysoft.repositories.datastorage;

import com.puggysoft.entities.datastorage.EntityStorageRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryStorageRecord extends JpaRepository<EntityStorageRecord, Long> {

  @Query(value = "SELECT COUNT(*) FROM storage_record;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM storage_record LIMIT ?1, ?2", nativeQuery = true)
  List<EntityStorageRecord> findStorageRecordByPagination(int off, int size);

}