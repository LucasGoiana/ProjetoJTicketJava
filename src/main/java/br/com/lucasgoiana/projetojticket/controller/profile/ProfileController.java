package br.com.lucasgoiana.projetojticket.controller.profile;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.profile.ProfileDTO;
import br.com.lucasgoiana.projetojticket.service.profile.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("perfil")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping(value = "")
    public List<ProfileDTO> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping(value = "/{id}")
    public ProfileDTO getProfileById(@PathVariable Integer id) {
        return profileService.getProfileById(id);
    }

    @PostMapping(value = "")
    public ProfileDTO createProfile(@RequestBody ProfileCreateOrUpdateDTO profileCreateOrUpdateDTO){
        return profileService.createProfile(profileCreateOrUpdateDTO);

    }
}