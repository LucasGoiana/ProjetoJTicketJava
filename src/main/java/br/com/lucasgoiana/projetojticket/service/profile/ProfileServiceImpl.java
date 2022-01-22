package br.com.lucasgoiana.projetojticket.service.profile;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.profile.ProfileDTO;
import br.com.lucasgoiana.projetojticket.entity.ProfileEntity;
import br.com.lucasgoiana.projetojticket.repository.profile.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        var profileList = profileRepository.findAll();
        return profileList.stream().map(ProfileDTO::converter).collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getProfileById(Integer id) {
        var profileEntity = profileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Perfil Não Encontrado"));
        return ProfileDTO.converter(profileEntity);
    }

    @Override
    public ProfileDTO createProfile(ProfileCreateOrUpdateDTO profileCreateOrUpdateDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileCreateOrUpdateDTO);
        profileEntity.setName(profileCreateOrUpdateDTO.getName());
        profileEntity.setModifiedDate(new Date());
        profileEntity = profileRepository.save(profileEntity);
        return ProfileDTO.converter(profileEntity);
    }
}
