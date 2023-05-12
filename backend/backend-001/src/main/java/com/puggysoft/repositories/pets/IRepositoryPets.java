package com.puggysoft.repositories.pets;

import com.puggysoft.entities.pets.EntityPets;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPets extends JpaRepository<EntityPets, Long> {

  @Query(value = "SELECT COUNT(*) FROM pets_pets;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM pets_pets LIMIT ?1, ?2", nativeQuery = true)
  List<EntityPets> findPetsByPagination(int off, int size);

}