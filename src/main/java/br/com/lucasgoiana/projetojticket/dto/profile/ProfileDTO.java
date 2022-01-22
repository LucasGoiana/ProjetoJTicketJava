package br.com.lucasgoiana.projetojticket.dto.profile;

import br.com.lucasgoiana.projetojticket.entity.profile.ProfileEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProfileDTO {
    private Integer idProfile;
    private String name;
    private Date modifiedDate;

    public static ProfileDTO converter(ProfileEntity profileEntity) {
        var profileDTO = new ProfileDTO();

        profileDTO.setIdProfile(profileEntity.getIdProfile());
        profileDTO.setName(profileEntity.getName());
        profileDTO.setModifiedDate(profileEntity.getModifiedDate());

        return profileDTO;
    }

}
