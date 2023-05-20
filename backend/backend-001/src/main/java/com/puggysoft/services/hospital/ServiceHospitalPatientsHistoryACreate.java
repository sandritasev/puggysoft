package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryA;
import com.puggysoft.entities.hospital.EntityHospitalPatientsHistoryA;
import com.puggysoft.repositories.hospital.IRepositoryHospitalPatientsHistoryA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceHospitalPatientsHistoryACreate {

  @Autowired
  private IRepositoryHospitalPatientsHistoryA repositoryHospitalPatientsHistoryA;

  /** method for create. */
  public ResponseEntity<String> create(DtoHospitalPatientsHistoryA dtoHospitalPatientsHistoryA) {
    try {
      EntityHospitalPatientsHistoryA entity = repositoryHospitalPatientsHistoryA
          .save(dtoHospitalPatientsHistoryA.dtoToEntity());
      DtoHospitalPatientsHistoryA dto = DtoHospitalPatientsHistoryA.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
