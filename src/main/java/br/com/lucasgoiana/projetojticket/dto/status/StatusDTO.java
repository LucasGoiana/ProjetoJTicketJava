package br.com.lucasgoiana.projetojticket.dto.status;

import br.com.lucasgoiana.projetojticket.entity.status.StatusEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class StatusDTO {

    private Integer idStatus;
    private String name;
    private Date modifieDate;

    public static StatusDTO converter(StatusEntity statusEntity){
        var statusDTO = new StatusDTO();

        statusDTO.setIdStatus(statusEntity.getIdStatus());
        statusDTO.setName(statusEntity.getName());
        statusDTO.setModifieDate(statusEntity.getModifiedDate());

        return statusDTO;

    }

}
