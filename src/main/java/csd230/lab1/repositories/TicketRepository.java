package csd230.lab1.repositories;

import csd230.lab1.entities.TicketEntity;
import csd230.lab1.pojos.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<Ticket> findTicketByDescription(String description);
    List<Ticket> findTicketByPrice(double price);
    Ticket findTicketById(long id);
    List<Ticket> findByDescriptionLike(String description);
}