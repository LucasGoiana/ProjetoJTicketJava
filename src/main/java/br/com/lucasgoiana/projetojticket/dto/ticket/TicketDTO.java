package br.com.lucasgoiana.projetojticket.dto.ticket;

import br.com.lucasgoiana.projetojticket.entity.ticket.TicketEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketDTO {

    private Integer idTicket;
    private String user;
    private String status;
    private String title;
    private String description;
    private String slug;
    private Date createdDate;
    private Date modifiedDate;


    public static TicketDTO converter(TicketEntity ticketEntity){
        var ticketDTO = new TicketDTO();

        ticketDTO.setIdTicket(ticketEntity.getIdTicket());
        ticketDTO.setUser(ticketEntity.getUserEntity().getName());
        ticketDTO.setStatus(ticketEntity.getStatusEntity().getName());
        ticketDTO.setTitle(ticketEntity.getTitle());
        ticketDTO.setDescription(ticketEntity.getDescription());
        ticketDTO.setSlug(ticketEntity.getSlug());
        ticketDTO.setCreatedDate(ticketEntity.getCreatedDate());
        ticketDTO.setModifiedDate(ticketEntity.getModifiedDate());

        return ticketDTO;
    }
}
