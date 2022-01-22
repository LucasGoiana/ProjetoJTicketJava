package br.com.lucasgoiana.projetojticket.repository.status;

import br.com.lucasgoiana.projetojticket.entity.status.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {


}
