package br.com.lucasgoiana.projetojticket.entity.ticket;

import br.com.lucasgoiana.projetojticket.dto.ticket.TicketCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.ticket.TicketUpdateStatusDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.entity.profile.ProfileEntity;
import br.com.lucasgoiana.projetojticket.entity.status.StatusEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idTicket", unique = true)
    private Integer idTicket;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idUser")
    private UserEntity userEntity;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idStatus")
    private StatusEntity statusEntity;
    private String title;
    private String description;
    private String slug;
    private Date createdDate;
    private Date modifiedDate;

    public TicketEntity(TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO) {
        this.title = ticketCreateOrUpdateDTO.getTitle();
        this.description = ticketCreateOrUpdateDTO.getDescription();
        this.slug = ticketCreateOrUpdateDTO.getSlug();
    }

    public TicketEntity(Integer id, Date date, StatusEntity statusEntity) {
        this.idTicket = id;
        this.modifiedDate = date;
        this.setStatusEntity(statusEntity);
    }
}

