package br.com.vamus.respositories;

import br.com.vamus.entities.TematicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TematicaRepository extends JpaRepository<TematicaEntity, Long>{


}
