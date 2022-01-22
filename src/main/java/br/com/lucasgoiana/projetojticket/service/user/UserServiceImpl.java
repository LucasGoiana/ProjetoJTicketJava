package br.com.lucasgoiana.projetojticket.service.user;

import br.com.lucasgoiana.projetojticket.dto.status.StatusDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;
import br.com.lucasgoiana.projetojticket.entity.status.StatusEntity;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import br.com.lucasgoiana.projetojticket.repository.user.UserRepository;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        var userList = userRepository.findAll();
        return userList.stream().map(UserDTO::converter).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserId(Integer id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não Encontrado"));
        return UserDTO.converter(userEntity);

    }

    @Override
    public UserDTO createUser(UserCreateOrUpdateDTO userCreateOrUpdateDTO) {
        var id = userRepository.findAllAtivas();
        var idInt = Integer.parseInt(id) + 1;

        UserEntity userEntity = new UserEntity(userCreateOrUpdateDTO);
        userEntity.setSlug(makeSlug(userCreateOrUpdateDTO.getName(), idInt));
        userEntity.setModifiedDate(new Date());
        userEntity = userRepository.save(userEntity);
        return UserDTO.converter(userEntity);


    }

    @Override
    public UserDTO updateUser(Integer id, UserCreateOrUpdateDTO userCreateOrUpdateDTO) {
        var user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
        UserEntity userEntity = new UserEntity(userCreateOrUpdateDTO);
        userEntity.setIdUser(id);
        userEntity.setIdProfile(user.getIdProfile());
        userEntity.setName(userCreateOrUpdateDTO.getName());
        userEntity.setEmail(userCreateOrUpdateDTO.getEmail());
        userEntity.setPassword(userCreateOrUpdateDTO.getPassword());
        userEntity.setSlug(makeSlug(userCreateOrUpdateDTO.getName(), id));
        userEntity.setModifiedDate(new Date());

        return UserDTO.converter(userEntity);
    }

    @Override
    public void deleteUser(Integer id) {
        var bank = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
        userRepository.deleteById(id);
    }

    public String makeSlug (String name, Integer id){
        return name.replace(' ', '-').toLowerCase(Locale.ROOT) + "-" + id;
    }
}
