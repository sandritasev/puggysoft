package com.puggysoft.repositories.hospital;

import com.puggysoft.entities.hospital.EntityHospitalDoctorsDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryHospitalDoctorsDetails extends JpaRepository<EntityHospitalDoctorsDetails, Long> {

  @Query(value = "SELECT COUNT(*) FROM hospital_doctors_details;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM hospital_doctors_details LIMIT ?1, ?2", nativeQuery = true)
  List<EntityHospitalDoctorsDetails> findHospitalDoctorsDetailsByPagination(int off, int size);

}