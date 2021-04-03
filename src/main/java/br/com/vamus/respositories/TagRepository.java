package br.com.vamus.respositories;

import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long>{


}
