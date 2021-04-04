package br.com.vamus.respositories;

import br.com.vamus.entities.MuseuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



import java.util.UUID;

@Repository
public interface MuseuRepository extends JpaRepository<MuseuEntity,
        Long> {
    Page<MuseuEntity> findAll(Pageable pageable);

}
