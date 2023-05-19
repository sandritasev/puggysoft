package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryA;
import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryAFilter;
import com.puggysoft.services.hospital.ServiceHospitalPatientsHistoryAGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsHistoryAGetFilter {

  @Autowired
  private ServiceHospitalPatientsHistoryAGetFilter serviceHospitalPatientsHistoryAGetFilter;

  @PostMapping(path = "/api/v1/hospital-patients-history-a/filter")
  public ResponseEntity<List<DtoHospitalPatientsHistoryA>> getHospitalPatientsHistoryAFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoHospitalPatientsHistoryAFilter dtoHospitalPatientsHistoryAFilter) {
    return serviceHospitalPatientsHistoryAGetFilter.filter(dtoHospitalPatientsHistoryAFilter, page, size);
  }
}