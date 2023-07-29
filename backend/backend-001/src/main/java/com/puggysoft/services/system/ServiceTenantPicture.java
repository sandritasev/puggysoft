package com.puggysoft.services.system;

import com.puggysoft.dtos.system.DtoTenant;
import com.puggysoft.entities.system.EntityTenant;
import com.puggysoft.repositories.system.IRepositoryTenant;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/** Services for picture update. */
@Service
public class ServiceTenantPicture {

  @Autowired
  private IRepositoryTenant repository;

  /** method for picture update. */
  public ResponseEntity<String> setPicture(MultipartFile file, Long tenantId) {

    Optional<EntityTenant> optionalEntity = repository.findById(tenantId);
    if (optionalEntity.isPresent()) {
      try {
        EntityTenant entity = optionalEntity.get();
        entity.setImage(file.getBytes());
        entity = repository.save(entity);
        DtoTenant dto = DtoTenant.entityToDto(entity);
        String idString = String.valueOf(dto.getId());
        return ResponseEntity.status(HttpStatus.OK).body(idString);
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      } catch (IOException ex) {
        String ioException = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ioException);
      } catch (Exception ex) {
        String genericException = ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(genericException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}
