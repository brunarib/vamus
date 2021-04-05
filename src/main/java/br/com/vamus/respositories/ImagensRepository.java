package br.com.vamus.respositories;

import br.com.vamus.entities.ImagensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagensRepository extends JpaRepository<ImagensEntity, Long> {
  
  @Query(nativeQuery = true, value = "select i.* from imagens i " +
    " left join museu_imagens mi on mi.imagem_id =i.id " +
    " where mi.museu_id =:id")
  List<ImagensEntity> findByMuseuId(@Param("id") Long id);
}
