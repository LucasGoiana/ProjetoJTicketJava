package br.com.lucasgoiana.projetojticket.service.ticket;

import br.com.lucasgoiana.projetojticket.dto.ticket.TicketCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.ticket.TicketDTO;
import br.com.lucasgoiana.projetojticket.entity.ticket.TicketEntity;
import br.com.lucasgoiana.projetojticket.repository.ticket.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDTO> getAllTicket() {
        var ticketList = ticketRepository.findAll();
        return ticketList.stream().map(TicketDTO::converter).collect(Collectors.toList());
    }

    @Override
    public TicketDTO getTicketId(Integer id) {
        var ticketEntity = ticketRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ticket não Encontrado"));
        return TicketDTO.converter(ticketEntity);

    }

    @Override
    public TicketDTO createTicket(TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO) {
        var id = ticketRepository.maxTicket();
        var idInt = Integer.parseInt(id) + 1;

        TicketEntity ticketEntity = new TicketEntity(ticketCreateOrUpdateDTO);
        ticketEntity.setIdTicket(idInt);
        ticketEntity.setSlug(makeSlug(ticketCreateOrUpdateDTO.getTitle(), idInt));
        ticketEntity.setCreatedDate(new Date());
        ticketEntity.setModifiedDate(new Date());
        ticketEntity = ticketRepository.save(ticketEntity);
        return TicketDTO.converter(ticketEntity);


    }

    @Override
    public TicketDTO updateTicket(Integer id, TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO) {
        var ticket = ticketRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ticket não encontrado"));
        TicketEntity ticketEntity = new TicketEntity(ticketCreateOrUpdateDTO);
        ticketEntity.setIdTicket(id);
        ticketEntity.setIdUser(ticketCreateOrUpdateDTO.getIdUser());
        ticketEntity.setDescription(ticketCreateOrUpdateDTO.getDescription());
        ticketEntity.setTitle(ticketCreateOrUpdateDTO.getTitle());
        ticketEntity.setSlug(makeSlug(ticketCreateOrUpdateDTO.getTitle(), id));
        ticketEntity.setModifiedDate(new Date());
        ticketEntity = ticketRepository.save(ticketEntity);
        return TicketDTO.converter(ticketEntity);
    }

    @Override
    public TicketDTO updateTicketByStatus(Integer id, Integer idStatus) {
        var ticket = ticketRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket Não Encontrado"));

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setIdTicket(id);
        ticketEntity.setIdStatus(idStatus);
        ticketEntity.setModifiedDate(new Date());
        return TicketDTO.converter(ticketEntity);
    }

    @Override
    public void deleteTicket(Integer id) {
        var ticket = ticketRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ticket não encontrado"));
        ticketRepository.deleteById(id);
    }

    public String makeSlug (String name, Integer id){
        return name.replace(' ', '-').toLowerCase(Locale.ROOT) + "-" + id;
    }
}
