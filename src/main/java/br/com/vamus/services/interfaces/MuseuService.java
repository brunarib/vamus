package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.MuseuInputDTO;
import br.com.vamus.entities.MuseuEntity;

import java.util.List;
import java.util.UUID;

public interface MuseuService {

    List<MuseuEntity> listMuseus();

    MuseuEntity create (MuseuInputDTO dto);

    MuseuEntity findById(Long id);
}
