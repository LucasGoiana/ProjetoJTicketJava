package br.com.lucasgoiana.projetojticket.entity.user;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idUser", unique = true)
    private Integer idUser;
    private Integer idProfile;
    private String name;
    private String email;
    private String password;
    private String slug;
    private Date modifiedDate;

    public UserEntity(UserCreateOrUpdateDTO userCreateOrUpdateDTO) {
        this.idProfile = userCreateOrUpdateDTO.getIdProfile();
        this.name = userCreateOrUpdateDTO.getName();
        this.email = userCreateOrUpdateDTO.getEmail();
        this.password = userCreateOrUpdateDTO.getPassword();
        this.slug = userCreateOrUpdateDTO.getSlug();
    }
}

