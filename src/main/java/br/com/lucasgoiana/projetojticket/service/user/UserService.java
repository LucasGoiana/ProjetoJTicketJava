package br.com.lucasgoiana.projetojticket.service.user;

import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserId(Integer id);

    UserDTO createUser(UserCreateOrUpdateDTO userCreateOrUpdateDTO);

    UserDTO updateUser(Integer id, UserCreateOrUpdateDTO userCreateOrUpdateDTO);

    void deleteUser(Integer id);
}
