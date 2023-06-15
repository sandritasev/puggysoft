package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityUrbanismoEstados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUrbanismoEstados extends JpaRepository<EntityUrbanismoEstados, Long> {

  @Query(value = "SELECT COUNT(*) FROM alc_urb_estados;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alc_urb_estados LIMIT ?1, ?2", nativeQuery = true)
  List<EntityUrbanismoEstados> findUrbanismoEstadosByPagination(int off, int size);

}