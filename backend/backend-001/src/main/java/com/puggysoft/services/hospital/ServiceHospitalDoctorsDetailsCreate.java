package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetails;
import com.puggysoft.entities.hospital.EntityHospitalDoctorsDetails;
import com.puggysoft.repositories.hospital.IRepositoryHospitalDoctorsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceHospitalDoctorsDetailsCreate {

  @Autowired
  private IRepositoryHospitalDoctorsDetails repositoryHospitalDoctorsDetails;

  /** method for create. */
  public ResponseEntity<String> create(DtoHospitalDoctorsDetails dtoHospitalDoctorsDetails) {
    try {
      EntityHospitalDoctorsDetails entity = repositoryHospitalDoctorsDetails
          .save(dtoHospitalDoctorsDetails.dtoToEntity());
      DtoHospitalDoctorsDetails dto = DtoHospitalDoctorsDetails.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
