package com.puggysoft.services.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTime;
import com.puggysoft.repositories.reservations.IRepositoryIntervalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceIntervalTimeEditById {

  @Autowired
  private IRepositoryIntervalTime repositoryIntervalTime;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoResIntervalTime dtoIntervalTime) {
    if (repositoryIntervalTime.existsById(id)) {
      try {
        dtoIntervalTime.setId(id.longValue());
        repositoryIntervalTime.save(dtoIntervalTime.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}