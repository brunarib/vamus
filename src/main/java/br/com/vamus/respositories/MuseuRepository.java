package br.com.vamus.respositories;

import br.com.vamus.entities.MuseuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseuRepository extends JpaRepository<MuseuEntity, Long> {
  Page<MuseuEntity> findAll(Pageable pageable);
  Page<MuseuEntity> findByCategoriaId(Pageable pageable, Long categoryId);
  
  @Query(nativeQuery = true, value = "SELECT *,(6371* \n" +
    "        acos(\n" +
    "         cos(radians(:latitude)) * \n" +
    "         cos(radians(latitude)) * \n" +
    "         cos(radians(:longitude) - radians(logitude)) + \n" +
    "         sin(radians(:latitude)) * \n" +
    "         sin(radians(latitude))\n" +
    "      )) AS CAMPOLATITUDE\n" +
    "FROM museus m2 HAVING CAMPOLATITUDE <=:km")
  Page<MuseuEntity>findNetherMuseus(@Param("latitude") String latitude,
                                    @Param("longitude")String longitude,
                                    @Param("km") int km, Pageable pageable);
}
