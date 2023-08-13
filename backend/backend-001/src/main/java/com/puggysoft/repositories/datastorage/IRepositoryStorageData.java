package com.puggysoft.repositories.datastorage;

import com.puggysoft.entities.datastorage.EntityStorageData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryStorageData extends JpaRepository<EntityStorageData, Long> {

  @Query(value = "SELECT COUNT(*) FROM storage_data;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM storage_data LIMIT ?1, ?2", nativeQuery = true)
  List<EntityStorageData> findStorageDataByPagination(int off, int size);

}