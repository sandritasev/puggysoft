package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleWorkDay;
import com.puggysoft.repositories.reservations.IRepositoryScheduleWorkDay;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get all roles. */
@Service
public class ServiceScheduleWorkDayGetAll {

  @Autowired
  private IRepositoryScheduleWorkDay repositoryScheduleWorkDay;

  /** method for retrive role. */
  public ResponseEntity<List<DtoResScheduleWorkDay>> getAll() {
    List<DtoResScheduleWorkDay> listDtoResScheduleWorkDay = repositoryScheduleWorkDay.findAll()
        .stream()
        .map(DtoResScheduleWorkDay::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoResScheduleWorkDay);
  }
}