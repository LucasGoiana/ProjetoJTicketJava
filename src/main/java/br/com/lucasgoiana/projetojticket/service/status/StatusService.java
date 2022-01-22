package br.com.lucasgoiana.projetojticket.service.status;

import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusCreateDTO;

import java.util.List;

public interface StatusService {

    List<StatusDTO> getAllStatus();

    StatusDTO getStatusId(Integer id);

    StatusDTO createStatus(StatusCreateDTO statusCreateDTO);
}
