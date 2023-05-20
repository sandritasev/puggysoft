package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetails;
import com.puggysoft.services.hospital.ServiceHospitalPatientsDetailsCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsDetailsPost {
  @Autowired
  private ServiceHospitalPatientsDetailsCreate serviceHospitalPatientsDetailsCreate;

  @PostMapping(path = "/api/v1/hospital-patients-details")
  public ResponseEntity<String> post(@RequestBody @Valid DtoHospitalPatientsDetails dtoHospitalPatientsDetails) {
    return serviceHospitalPatientsDetailsCreate.create(dtoHospitalPatientsDetails);
  }
}