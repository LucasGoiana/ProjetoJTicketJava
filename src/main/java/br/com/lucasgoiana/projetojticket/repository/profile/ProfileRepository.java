package br.com.lucasgoiana.projetojticket.repository.profile;

import br.com.lucasgoiana.projetojticket.entity.profile.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {


}
