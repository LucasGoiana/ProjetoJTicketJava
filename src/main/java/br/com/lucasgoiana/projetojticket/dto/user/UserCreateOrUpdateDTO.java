package br.com.lucasgoiana.projetojticket.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateOrUpdateDTO {
        private Integer idProfile;
        private String name;
        private String email;
        private String password;
        private String slug;
}
