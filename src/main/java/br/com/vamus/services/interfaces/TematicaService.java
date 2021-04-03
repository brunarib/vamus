package br.com.vamus.services.interfaces;


import br.com.vamus.controller.dtos.TematicaDTO;

import br.com.vamus.entities.TematicaEntity;

import java.util.List;
import java.util.UUID;

public interface TematicaService {

    List<TematicaEntity> listTematicas();

    TematicaEntity create (TematicaDTO dto);

    TematicaEntity findById(Long id);
}
