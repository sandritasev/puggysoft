package com.puggysoft.repositories.hospital;

import com.puggysoft.entities.hospital.EntityHospitalPatientsHistoryA;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryHospitalPatientsHistoryA extends JpaRepository<EntityHospitalPatientsHistoryA, Long> {

  @Query(value = "SELECT COUNT(*) FROM hospital_patients_history_a;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM hospital_patients_history_a LIMIT ?1, ?2", nativeQuery = true)
  List<EntityHospitalPatientsHistoryA> findHospitalPatientsHistoryAByPagination(int off, int size);

}
