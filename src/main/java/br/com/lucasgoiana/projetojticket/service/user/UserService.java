package br.com.lucasgoiana.projetojticket.service.user;


import br.com.lucasgoiana.projetojticket.dto.ticket.TicketCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.ticket.TicketDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserId(Integer id);

    UserDTO createUser(UserCreateOrUpdateDTO userCreateOrUpdateDTO) throws NoSuchAlgorithmException;

    UserDTO updateUser(Integer id, UserCreateOrUpdateDTO userCreateOrUpdateDTO) throws NoSuchAlgorithmException;

    void deleteUser(Integer id);
}
