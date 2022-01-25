package br.com.lucasgoiana.projetojticket.dto.user;

import br.com.lucasgoiana.projetojticket.entity.profile.ProfileEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateOrUpdateDTO {
        private Integer idProfile;
        private String name;
        private String email;
        private String password;
        private String slug;

}
