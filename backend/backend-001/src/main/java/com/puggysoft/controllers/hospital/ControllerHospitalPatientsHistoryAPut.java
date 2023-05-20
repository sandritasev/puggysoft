package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryA;
import com.puggysoft.services.hospital.ServiceHospitalPatientsHistoryAEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsHistoryAPut {

  @Autowired
  private ServiceHospitalPatientsHistoryAEditById serviceHospitalPatientsHistoryAEditById;

  @PutMapping(path = "/api/v1/hospital-patients-history-a/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoHospitalPatientsHistoryA dtoHospitalPatientsHistoryA) {
    return serviceHospitalPatientsHistoryAEditById.editById(id, dtoHospitalPatientsHistoryA);
  }
}
