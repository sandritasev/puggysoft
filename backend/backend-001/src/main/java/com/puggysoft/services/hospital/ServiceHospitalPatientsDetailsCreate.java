package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetails;
import com.puggysoft.entities.hospital.EntityHospitalPatientsDetails;
import com.puggysoft.repositories.hospital.IRepositoryHospitalPatientsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceHospitalPatientsDetailsCreate {

  @Autowired
  private IRepositoryHospitalPatientsDetails repositoryHospitalPatientsDetails;

  /** method for create. */
  public ResponseEntity<String> create(DtoHospitalPatientsDetails dtoHospitalPatientsDetails) {
    try {
      EntityHospitalPatientsDetails entity = repositoryHospitalPatientsDetails
          .save(dtoHospitalPatientsDetails.dtoToEntity());
      DtoHospitalPatientsDetails dto = DtoHospitalPatientsDetails.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
