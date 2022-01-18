package br.com.lucasgoiana.projetojticket.dto.profile;

import br.com.lucasgoiana.projetojticket.entity.ProfileEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProfileDTO {
    private Long id;
    private String name;
    private Date modifiedDate;

    public static ProfileDTO converter(ProfileEntity profileEntity) {
        var profileDTO = new ProfileDTO();

        profileDTO.setId(profileEntity.getId());
        profileDTO.setName(profileEntity.getName());
        profileDTO.setModifiedDate(profileEntity.getModifiedDate());

        return profileDTO;
    }

}
