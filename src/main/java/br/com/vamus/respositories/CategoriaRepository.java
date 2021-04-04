package br.com.vamus.respositories;

import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,
        Long>{

        CategoriaEntity findCategoriaById(Long id);
        Page<CategoriaEntity> findAll(Pageable pageable);

}
