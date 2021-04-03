package br.com.vamus.respositories;

import br.com.vamus.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,
        Long>{


}
