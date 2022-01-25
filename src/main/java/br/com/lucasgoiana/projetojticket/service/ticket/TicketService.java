package br.com.lucasgoiana.projetojticket.service.ticket;

import br.com.lucasgoiana.projetojticket.dto.ticket.TicketCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.ticket.TicketDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;

import java.util.List;

public interface TicketService {


    List<TicketDTO> getAllTicket();

    TicketDTO getTicketId(Integer id);

    TicketDTO createTicket(TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO);

    TicketDTO updateTicket(Integer id, TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO);

    TicketDTO updateTicketByStatus(Integer id, Integer idStatus);

    void deleteTicket(Integer id);


}
