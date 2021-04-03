package br.com.vamus.respositories;


import br.com.vamus.entities.MuseuFuncionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface MuseuFuncionamentoRepository extends JpaRepository<MuseuFuncionamentoEntity, Long>{


}
