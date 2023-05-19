package com.puggysoft.repositories.hospital;

import com.puggysoft.entities.hospital.EntityHospitalPatientsDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryHospitalPatientsDetails extends JpaRepository<EntityHospitalPatientsDetails, Long> {

  @Query(value = "SELECT COUNT(*) FROM hospital_patients_details;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM hospital_patients_details LIMIT ?1, ?2", nativeQuery = true)
  List<EntityHospitalPatientsDetails> findHospitalPatientsDetailsByPagination(int off, int size);

}