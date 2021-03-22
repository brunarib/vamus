package br.com.vamus.respositories;

import br.com.vamus.entities.MuseuEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

@Repository
public interface MuseuRepository extends JpaRepository<MuseuEntity, Id>{

}
