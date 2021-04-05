package br.com.vamus.respositories;

import br.com.vamus.entities.MuseuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseuRepository extends JpaRepository<MuseuEntity, Long> {
  Page<MuseuEntity> findAll(Pageable pageable);
  Page<MuseuEntity> findByCategoriaId(Pageable pageable, Long categoryId);
}
