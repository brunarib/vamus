package br.com.vamus.respositories;


import br.com.vamus.entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, Long>{


  /*  List<EventoEntity> findByMuseuId(Long id);
    List<EventoEntity> findIsGratuito(Boolean gratuito);
    List<EventoEntity> findMuseuCategoriaId(Long id);*/

    @Query(nativeQuery = true, value = "select * from vamus.eventos where " +
            "ini_evento>=:inicio and fim_evento<=:fim")
    List<EventoEntity> findByDate(@Param("inicio") LocalDateTime ini,
                                  @Param("fim") LocalDateTime fim);

    @Query(nativeQuery = true, value = "select * from vamus.eventos where " +
            " now() between ini_evento and fim_evento")
    List<EventoEntity> findByDateNow();


}
