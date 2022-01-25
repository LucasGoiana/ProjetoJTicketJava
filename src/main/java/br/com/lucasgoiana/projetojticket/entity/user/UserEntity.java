package br.com.lucasgoiana.projetojticket.entity.user;

import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;
import br.com.lucasgoiana.projetojticket.entity.profile.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idUser", unique = true)
    private Integer idUser;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idProfile")
    private ProfileEntity profileEntity;

    private String name;
    private String email;
    private String password;
    private String slug;
    private Date modifiedDate;

    public UserEntity(UserCreateOrUpdateDTO userCreateOrUpdateDTO){
        this.name = userCreateOrUpdateDTO.getName();
        this.email = userCreateOrUpdateDTO.getEmail();
        this.password = userCreateOrUpdateDTO.getPassword();
        this.slug = userCreateOrUpdateDTO.getSlug();
    }
}

