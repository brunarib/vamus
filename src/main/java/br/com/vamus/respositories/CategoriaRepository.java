package br.com.vamus.respositories;

import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,
        Long>{


        CategoriaEntity findCategoriaById(Long id);

}
