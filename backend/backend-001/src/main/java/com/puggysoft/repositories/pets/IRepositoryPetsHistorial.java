package com.puggysoft.repositories.pets;

import com.puggysoft.entities.pets.EntityPetsHistorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPetsHistorial extends JpaRepository<EntityPetsHistorial, Long> {

  @Query(value = "SELECT COUNT(*) FROM pets_historial;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM pets_historial LIMIT ?1, ?2", nativeQuery = true)
  List<EntityPetsHistorial> findPetsHistorialByPagination(int off, int size);

}