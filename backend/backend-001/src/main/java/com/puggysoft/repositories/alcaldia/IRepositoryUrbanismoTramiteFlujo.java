package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityUrbanismoTramiteFlujo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUrbanismoTramiteFlujo extends JpaRepository<EntityUrbanismoTramiteFlujo, Long> {

  @Query(value = "SELECT COUNT(*) FROM alc_urb_tramite_flujo;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alc_urb_tramite_flujo LIMIT ?1, ?2", nativeQuery = true)
  List<EntityUrbanismoTramiteFlujo> findUrbanismoTramiteFlujoByPagination(int off, int size);

}