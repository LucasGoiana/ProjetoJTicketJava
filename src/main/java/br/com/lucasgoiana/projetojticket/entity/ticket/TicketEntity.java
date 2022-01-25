package br.com.lucasgoiana.projetojticket.entity.ticket;

import br.com.lucasgoiana.projetojticket.dto.ticket.TicketCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idTicket", unique = true)
    private Integer idTicket;
    private Integer idUser;


    private Integer idStatus;
    private String title;
    private String description;
    private String slug;
    private Date createdDate;
    private Date modifiedDate;

    public TicketEntity(TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO) {
        this.idUser = ticketCreateOrUpdateDTO.getIdUser();
        this.idStatus = ticketCreateOrUpdateDTO.getIdStatus();
        this.title = ticketCreateOrUpdateDTO.getTitle();
        this.description = ticketCreateOrUpdateDTO.getDescription();
        this.slug = ticketCreateOrUpdateDTO.getSlug();
    }
}

