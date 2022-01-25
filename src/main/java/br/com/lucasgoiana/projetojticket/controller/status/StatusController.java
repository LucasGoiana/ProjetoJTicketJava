package br.com.lucasgoiana.projetojticket.controller.status;

import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusCreateDTO;
import br.com.lucasgoiana.projetojticket.service.status.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping(value = "")
    public List<StatusDTO> getAllStatus() {
        return statusService.getAllStatus();
    }

    @GetMapping(value = "/{id}")
    public StatusDTO getProfileById(@PathVariable Integer id) {
        return statusService.getStatusId(id);
    }

    @PostMapping(value = "")
    public Map<String, String> createStatus(@RequestBody StatusCreateDTO profileCreateDTO){
       statusService.createStatus(profileCreateDTO);
       HashMap<String, String> map = new HashMap<>();
       map.put("msg", "Cadastrado com Sucesso!");

       return map;

    }
}
