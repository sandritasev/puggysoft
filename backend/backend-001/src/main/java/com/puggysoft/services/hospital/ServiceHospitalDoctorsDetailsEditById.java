package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetails;
import com.puggysoft.repositories.hospital.IRepositoryHospitalDoctorsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceHospitalDoctorsDetailsEditById {

  @Autowired
  private IRepositoryHospitalDoctorsDetails repositoryHospitalDoctorsDetails;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoHospitalDoctorsDetails dtoHospitalDoctorsDetails) {
    if (repositoryHospitalDoctorsDetails.existsById(id)) {
      try {
        dtoHospitalDoctorsDetails.setId(id.longValue());
        repositoryHospitalDoctorsDetails.save(dtoHospitalDoctorsDetails.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}
