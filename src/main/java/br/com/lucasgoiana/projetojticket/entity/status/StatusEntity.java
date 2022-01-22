package br.com.lucasgoiana.projetojticket.entity.status;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusCreateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idStatus")
    private Integer idStatus;
    private String name;
    private Date modifiedDate;

    public StatusEntity(StatusCreateDTO statusCreateDTO) {
        this.name = statusCreateDTO.getName();
    }
}
