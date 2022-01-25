package br.com.lucasgoiana.projetojticket.dto.ticket;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketCreateOrUpdateDTO {
        private Integer idTicket;
        private Integer idUser;
        private Integer idStatus;
        private String title;
        private String description;
        private String slug;
        private Date createdDate;
        private Date modifiedDate;
}
