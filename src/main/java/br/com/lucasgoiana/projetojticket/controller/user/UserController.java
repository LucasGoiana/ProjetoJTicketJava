package br.com.lucasgoiana.projetojticket.controller.user;

import br.com.lucasgoiana.projetojticket.dto.status.StatusCreateDTO;
import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;
import br.com.lucasgoiana.projetojticket.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getUserId(@PathVariable Integer id) {
        return userService.getUserId(id);
    }

    @PostMapping(value = "")
    public UserDTO createUser(@RequestBody UserCreateOrUpdateDTO userCreateOrUpdateDTO){
        return userService.createUser(userCreateOrUpdateDTO);
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@PathVariable Integer id,  @RequestBody UserCreateOrUpdateDTO userCreateOrUpdateDTO){
        return userService.updateUser(id, userCreateOrUpdateDTO);
    }
}
