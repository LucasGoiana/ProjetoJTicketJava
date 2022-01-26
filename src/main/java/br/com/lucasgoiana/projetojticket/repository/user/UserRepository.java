package br.com.lucasgoiana.projetojticket.repository.user;

import br.com.lucasgoiana.projetojticket.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select MAX(idUser) from user",  nativeQuery = true)
    String findAllAtivas();


    @Query(value = "select COUNT(idUser) from user where email = :email",  nativeQuery = true)
    String email(@Param("email") String email);
}
