package br.com.lucasgoiana.projetojticket.dto.ticket;

import br.com.lucasgoiana.projetojticket.entity.status.StatusEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketCreateOrUpdateDTO {

        private Integer idUser;
        private Integer idStatus;
        private String title;
        private String description;
        private String slug;
        private Date createdDate;
        private Date modifiedDate;
}
