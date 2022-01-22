package br.com.lucasgoiana.projetojticket.service.profile;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.profile.ProfileDTO;

import java.util.List;

public interface ProfileService {
    List<ProfileDTO> getAllProfiles();

    ProfileDTO getProfileById(Integer id);

    ProfileDTO createProfile(ProfileCreateOrUpdateDTO profileCreateOrUpdateDTO);
}
