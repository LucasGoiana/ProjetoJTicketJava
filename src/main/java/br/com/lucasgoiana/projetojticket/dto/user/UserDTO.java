package br.com.lucasgoiana.projetojticket.dto.user;

import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {

    private Integer idUser;
    private String profile;
    private String name;
    private String email;
    private String password;
    private String slug;
    private Date modifiedDate;

    public static UserDTO converter(UserEntity userEntity){
        var userDTO = new UserDTO();

        userDTO.setIdUser(userEntity.getIdUser());
        userDTO.setProfile(userEntity.getProfileEntity().getName());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setSlug(userEntity.getSlug());
        userDTO.setModifiedDate(userEntity.getModifiedDate());

        return userDTO;
    }
}
