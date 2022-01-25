package br.com.lucasgoiana.projetojticket.controller.user;

import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;
import br.com.lucasgoiana.projetojticket.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, String> createUser(@RequestBody UserCreateOrUpdateDTO userCreateOrUpdateDTO) throws NoSuchAlgorithmException {
      userService.createUser(userCreateOrUpdateDTO);
      HashMap<String, String> map = new HashMap<>();
      map.put("msg", "Cadastrado com Sucesso!");

      return map;

    }

    @PutMapping(value = "/{id}")
    public Map<String, String>  updateUser(@PathVariable Integer id,  @RequestBody UserCreateOrUpdateDTO userCreateOrUpdateDTO) throws NoSuchAlgorithmException {
        userService.updateUser(id, userCreateOrUpdateDTO);
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "Editado com Sucesso!");

        return map;
    }

    @DeleteMapping(value = "/{id}")
    public  Map<String, String>  deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        HashMap<String, String> map = new HashMap<>();
        map.put("msg", "Usuário foi com Sucesso!");

        return map;
    }
}
