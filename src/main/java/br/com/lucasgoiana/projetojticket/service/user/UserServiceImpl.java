package br.com.lucasgoiana.projetojticket.service.user;

import br.com.lucasgoiana.projetojticket.dto.user.UserCreateOrUpdateDTO;
import br.com.lucasgoiana.projetojticket.dto.user.UserDTO;
import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import br.com.lucasgoiana.projetojticket.repository.profile.ProfileRepository;
import br.com.lucasgoiana.projetojticket.repository.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserServiceImpl(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        var userList = userRepository.findAll();
        return userList.stream().map(UserDTO::converter).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserId(Integer id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não Encontrado"));
        return UserDTO.converter(userEntity);

    }

    @Override
    public UserDTO createUser(UserCreateOrUpdateDTO userCreateOrUpdateDTO) throws NoSuchAlgorithmException {
        var id = userRepository.findAllAtivas();
        var idProfile = profileRepository.findById(userCreateOrUpdateDTO.getIdProfile()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não Encontrado"));
        var idInt = Integer.parseInt(id) + 1;

        UserEntity userEntity = new UserEntity(userCreateOrUpdateDTO);
        userEntity.setProfileEntity(idProfile);
        userEntity.setPassword(md5(userCreateOrUpdateDTO.getPassword()));
        userEntity.setSlug(makeSlug(userCreateOrUpdateDTO.getName(), idInt));
        userEntity.setModifiedDate(new Date());
        userEntity = userRepository.save(userEntity);
        return UserDTO.converter(userEntity);


    }

    @Override
    public UserDTO updateUser(Integer id, UserCreateOrUpdateDTO userCreateOrUpdateDTO) throws NoSuchAlgorithmException {
        var user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        UserEntity userEntity = new UserEntity(userCreateOrUpdateDTO);
        userEntity.setIdUser(id);
        userEntity.setName(userCreateOrUpdateDTO.getName());
        userEntity.setEmail(userCreateOrUpdateDTO.getEmail());
        userEntity.setPassword(md5(userCreateOrUpdateDTO.getPassword()));
        userEntity.setSlug(makeSlug(userCreateOrUpdateDTO.getName(), id));
        userEntity.setModifiedDate(new Date());
        userEntity = userRepository.save(userEntity);

        return UserDTO.converter(userEntity);
    }

    @Override
    public void deleteUser(Integer id) {
        var bank = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        userRepository.deleteById(id);
    }

    public String makeSlug(String name, Integer id) {
        return name.replace(' ', '-').toLowerCase(Locale.ROOT) + "-" + id;
    }

    public String md5(String password) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
}
