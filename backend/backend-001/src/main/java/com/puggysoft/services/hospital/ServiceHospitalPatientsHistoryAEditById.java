package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryA;
import com.puggysoft.repositories.hospital.IRepositoryHospitalPatientsHistoryA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceHospitalPatientsHistoryAEditById {

  @Autowired
  private IRepositoryHospitalPatientsHistoryA repositoryHospitalPatientsHistoryA;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoHospitalPatientsHistoryA dtoHospitalPatientsHistoryA) {
    if (repositoryHospitalPatientsHistoryA.existsById(id)) {
      try {
        dtoHospitalPatientsHistoryA.setId(id.longValue());
        repositoryHospitalPatientsHistoryA.save(dtoHospitalPatientsHistoryA.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}
