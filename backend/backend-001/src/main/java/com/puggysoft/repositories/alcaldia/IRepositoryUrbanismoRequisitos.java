package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityUrbanismoRequisitos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUrbanismoRequisitos extends JpaRepository<EntityUrbanismoRequisitos, Long> {

  @Query(value = "SELECT COUNT(*) FROM alc_urb_requisitos;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alc_urb_requisitos LIMIT ?1, ?2", nativeQuery = true)
  List<EntityUrbanismoRequisitos> findUrbanismoRequisitosByPagination(int off, int size);

}