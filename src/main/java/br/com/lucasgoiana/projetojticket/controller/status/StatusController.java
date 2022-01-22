package br.com.lucasgoiana.projetojticket.controller.status;

import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusCreateDTO;
import br.com.lucasgoiana.projetojticket.service.status.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public StatusDTO createStatus(@RequestBody StatusCreateDTO profileCreateDTO){
        return statusService.createStatus(profileCreateDTO);

    }
}
