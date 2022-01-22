package br.com.lucasgoiana.projetojticket.entity;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="profile")
public class ProfileEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idProfile", unique = true)
    @JsonProperty("idProfile")
    private Integer idProfile;
    @Column(name="name")
    private String name ;
    @Column(name="modifiedDate")
    private Date modifiedDate;

    public ProfileEntity(ProfileCreateOrUpdateDTO profileCreateOrUpdateDTO) {
        this.name = profileCreateOrUpdateDTO.getName();
    }
}
