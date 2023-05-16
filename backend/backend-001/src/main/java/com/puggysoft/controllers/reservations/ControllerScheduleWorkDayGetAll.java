package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleWorkDay;
import com.puggysoft.services.reservations.ServiceScheduleWorkDayGetAll;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScheduleWorkDayGetAll {

  @Autowired
  private ServiceScheduleWorkDayGetAll serviceScheduleWorkDayGetAll;

  @GetMapping(path = "/api/v1/reservations-schedules-works-days")
  public ResponseEntity<List<DtoResScheduleWorkDay>> getAll() {
    return serviceScheduleWorkDayGetAll.getAll();
  }
}
