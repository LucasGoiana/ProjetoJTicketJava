package br.com.lucasgoiana.projetojticket.repository.ticket;

import br.com.lucasgoiana.projetojticket.entity.ticket.TicketEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    @Query(value = "select MAX(idTicket) from ticket",  nativeQuery = true)
    String maxTicket();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ticket where idUser = :idUser",  nativeQuery = true)
    void deleteIdUser(@Param("idUser") Integer idUser);

}
