package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResSchedule;
import com.puggysoft.repositories.reservations.IRepositorySchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceScheduleEditById {

  @Autowired
  private IRepositorySchedule repositorySchedule;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoResSchedule dtoSchedule) {
    if (repositorySchedule.existsById(id)) {
      try {
        dtoSchedule.setId(id.longValue());
        repositorySchedule.save(dtoSchedule.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}