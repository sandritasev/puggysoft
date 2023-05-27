package com.puggysoft.repositories.reservations;

import com.puggysoft.entities.reservations.EntityResResourceSchedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryResourceSchedule extends JpaRepository<EntityResResourceSchedule, Long> {

  @Query(value = "SELECT COUNT(*) FROM res_resources;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM res_resources LIMIT ?1, ?2", nativeQuery = true)
  List<EntityResResourceSchedule> findResourceScheduleByPagination(int off, int size);

}