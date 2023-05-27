package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryAFilter;
import com.puggysoft.services.hospital.ServiceHospitalPatientsHistoryAGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsHistoryAGetFilterSize {

  @Autowired
  private ServiceHospitalPatientsHistoryAGetFilterSize serviceHospitalPatientsHistoryAGetFilterSize;

  @PostMapping(path = "/api/v1/hospital-patients-history-a/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoHospitalPatientsHistoryAFilter dtoHospitalPatientsHistoryAFilter,
      @PathVariable Long pageSize) {
    return serviceHospitalPatientsHistoryAGetFilterSize.getSize(dtoHospitalPatientsHistoryAFilter,
        pageSize);
  }
}