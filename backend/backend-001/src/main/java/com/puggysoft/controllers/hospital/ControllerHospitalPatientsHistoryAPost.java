package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryA;
import com.puggysoft.services.hospital.ServiceHospitalPatientsHistoryACreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsHistoryAPost {
  @Autowired
  private ServiceHospitalPatientsHistoryACreate serviceHospitalPatientsHistoryACreate;

  @PostMapping(path = "/api/v1/hospital-patients-history-a")
  public ResponseEntity<String> post(@RequestBody @Valid DtoHospitalPatientsHistoryA dtoHospitalPatientsHistoryA) {
    return serviceHospitalPatientsHistoryACreate.create(dtoHospitalPatientsHistoryA);
  }
}