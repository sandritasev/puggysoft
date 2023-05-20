package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetails;
import com.puggysoft.services.hospital.ServiceHospitalPatientsDetailsEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsDetailsPut {

  @Autowired
  private ServiceHospitalPatientsDetailsEditById serviceHospitalPatientsDetailsEditById;

  @PutMapping(path = "/api/v1/hospital-patients-details/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoHospitalPatientsDetails dtoHospitalPatientsDetails) {
    return serviceHospitalPatientsDetailsEditById.editById(id, dtoHospitalPatientsDetails);
  }
}
