package com.puggysoft.repositories.tickets;

import com.puggysoft.entities.tickets.EntityTickets;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryTickets extends JpaRepository<EntityTickets, Long> {

  @Query(value = "SELECT COUNT(*) FROM tickets;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM tickets LIMIT ?1, ?2", nativeQuery = true)
  List<EntityTickets> findTicketsByPagination(int off, int size);

}