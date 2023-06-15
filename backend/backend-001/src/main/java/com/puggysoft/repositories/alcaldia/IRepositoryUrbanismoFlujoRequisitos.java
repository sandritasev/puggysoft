package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityUrbanismoFlujoRequisitos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUrbanismoFlujoRequisitos extends JpaRepository<EntityUrbanismoFlujoRequisitos, Long> {

  @Query(value = "SELECT COUNT(*) FROM alc_urb_tramite_flujo_requisitos;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alc_urb_tramite_flujo_requisitos LIMIT ?1, ?2", nativeQuery = true)
  List<EntityUrbanismoFlujoRequisitos> findUrbanismoFlujoRequisitosByPagination(int off, int size);

}