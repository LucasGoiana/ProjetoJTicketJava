package br.com.lucasgoiana.projetojticket.repository.ticket;

import br.com.lucasgoiana.projetojticket.entity.ticket.TicketEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    @Query(value = "select MAX(idTicket) from ticket",  nativeQuery = true)
    String maxTicket();
}
