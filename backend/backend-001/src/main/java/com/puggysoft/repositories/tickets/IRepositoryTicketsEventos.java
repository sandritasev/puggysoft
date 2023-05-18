package com.puggysoft.repositories.tickets;

import com.puggysoft.entities.tickets.EntityTicketsEventos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryTicketsEventos extends JpaRepository<EntityTicketsEventos, Long> {

  @Query(value = "SELECT COUNT(*) FROM tickets_eventos;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM tickets_eventos LIMIT ?1, ?2", nativeQuery = true)
  List<EntityTicketsEventos> findTicketsEventosByPagination(int off, int size);

}