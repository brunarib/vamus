package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.MuseuInputDTO;
import br.com.vamus.controller.dtos.MuseuOutputDTO;
import br.com.vamus.entities.MuseuEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MuseuService {

    List<MuseuEntity> listMuseus();

   Page<List<MuseuOutputDTO>> findMuseus(MuseuOutputDTO museuOutputDTO,
                                      Pageable pageable) throws JsonProcessingException;


        MuseuEntity create (MuseuInputDTO dto);

    MuseuEntity findById(Long id);
}
