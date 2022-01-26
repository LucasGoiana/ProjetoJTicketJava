package br.com.lucasgoiana.projetojticket.controller.ticket;

import br.com.lucasgoiana.projetojticket.dto.ticket.TicketCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.ticket.TicketDTO;
import br.com.lucasgoiana.projetojticket.service.status.StatusService;
import br.com.lucasgoiana.projetojticket.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private JavaMailSender mailSender;
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "")
    public List<TicketDTO> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @GetMapping(value = "/{id}")
    public TicketDTO getTicketId(@PathVariable Integer id) {
        return ticketService.getTicketId(id);
    }

    @PostMapping(value = "")
    public Map<String, String> createTicket(@RequestBody TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO){
        ticketService.createTicket(ticketCreateOrUpdateDTO);
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "Cadastrado com Sucesso!");

        return map;

    }

    @PutMapping(value = "/{id}")
    public Map<String, String> updateTicket(@PathVariable Integer id,  @RequestBody TicketCreateOrUpdateDTO ticketCreateOrUpdateDTO){
        ticketService.updateTicket(id, ticketCreateOrUpdateDTO);
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "Editado com Sucesso!");

        return map;
    }

    @PutMapping(value = "/{id}/status/{idStatus}")
    public Map<String, String>  updateTicketByStatus(@PathVariable Integer id, @PathVariable Integer idStatus){
       ticketService.updateTicketByStatus(id, idStatus, mailSender);
       HashMap<String, String> map = new HashMap<>();
       map.put("msg", "Editado com Sucesso!");

       return map;
    }

    @DeleteMapping(value = "/{id}")
    public Map<String, String> deleteTicket(@PathVariable Integer id){
        ticketService.deleteTicket(id);
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "Ticket foi Deletado com Sucesso!");

        return map;
    }
}
