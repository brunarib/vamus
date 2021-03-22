package br.com.vamus.respositories;

import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Id>{

    CategoriaEntity findById(Integer id);
}
