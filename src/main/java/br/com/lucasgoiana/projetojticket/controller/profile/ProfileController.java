package br.com.lucasgoiana.projetojticket.controller.profile;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.profile.ProfileDTO;
import br.com.lucasgoiana.projetojticket.service.profile.ProfileService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, String> createProfile(@RequestBody ProfileCreateOrUpdateDTO profileCreateOrUpdateDTO) throws JSONException {

        profileService.createProfile(profileCreateOrUpdateDTO);
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "Cadastrado com Sucesso!");

        return map;
    }
}