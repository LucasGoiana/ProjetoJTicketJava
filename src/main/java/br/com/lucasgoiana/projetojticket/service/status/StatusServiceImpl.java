package br.com.lucasgoiana.projetojticket.service.status;

import br.com.lucasgoiana.projetojticket.dto.profile.ProfileDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusCreateDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.entity.profile.ProfileEntity;
import br.com.lucasgoiana.projetojticket.entity.status.StatusEntity;
import br.com.lucasgoiana.projetojticket.repository.profile.ProfileRepository;
import br.com.lucasgoiana.projetojticket.repository.status.StatusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @Override
    public List<StatusDTO> getAllStatus() {
        var statusList = statusRepository.findAll();
        return statusList.stream().map(StatusDTO::converter).collect(Collectors.toList());
    }

    @Override
    public StatusDTO getStatusId(Integer id) {
        var statusEntity = statusRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Perfil Não Encontrado"));
        return StatusDTO.converter(statusEntity);
    }

    @Override
    public StatusDTO createStatus(StatusCreateDTO statusCreateDTO) {
        StatusEntity statusEntity = new StatusEntity(statusCreateDTO);
        statusEntity.setName(statusCreateDTO.getName());
        statusEntity.setModifiedDate(new Date());
        statusEntity = statusRepository.save(statusEntity);
        return StatusDTO.converter(statusEntity);
    }
}
