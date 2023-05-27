package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetailsFilter;
import com.puggysoft.services.hospital.ServiceHospitalPatientsDetailsGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsDetailsGetFilterSize {

  @Autowired
  private ServiceHospitalPatientsDetailsGetFilterSize serviceHospitalPatientsDetailsGetFilterSize;

  @PostMapping(path = "/api/v1/hospital-patients-details/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoHospitalPatientsDetailsFilter dtoHospitalPatientsDetailsFilter,
      @PathVariable Long pageSize) {
    return serviceHospitalPatientsDetailsGetFilterSize.getSize(dtoHospitalPatientsDetailsFilter,
        pageSize);
  }
}