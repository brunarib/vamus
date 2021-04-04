package br.com.vamus.respositories;


import br.com.vamus.controller.dtos.MuseuDetalhesOutputDTO;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.entities.MuseuFuncionamentoEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface MuseuFuncionamentoRepository extends JpaRepository<MuseuFuncionamentoEntity, Long>{

    @Query(nativeQuery = true, value = "select * from vamus" +
            ".museu_funcionamento " +
            " where museu_id=:id")
    MuseuFuncionamentoEntity findFuncionamentoByMuseuId(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select * from vamus" +
            ".museus_em_funcionamento where :dia =true")
    List<MuseuDetalhesOutputDTO> findByFuncionamentoNow(@Param("dia")String dia);

}
