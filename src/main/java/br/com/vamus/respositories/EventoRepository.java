package br.com.vamus.respositories;


import br.com.vamus.entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, Long>{


}