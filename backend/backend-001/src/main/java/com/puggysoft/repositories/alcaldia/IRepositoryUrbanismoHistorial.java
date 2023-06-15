package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityUrbanismoHistorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUrbanismoHistorial extends JpaRepository<EntityUrbanismoHistorial, Long> {

  @Query(value = "SELECT COUNT(*) FROM alc_urb_historial;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alc_urb_historial LIMIT ?1, ?2", nativeQuery = true)
  List<EntityUrbanismoHistorial> findUrbanismoHistorialByPagination(int off, int size);

}