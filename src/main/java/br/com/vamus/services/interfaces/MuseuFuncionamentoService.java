package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.MuseuFuncionamentoOutputDTO;
import br.com.vamus.controller.dtos.MuseuInputDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.entities.MuseuFuncionamentoEntity;

import java.util.List;
import java.util.UUID;


public interface MuseuFuncionamentoService {

    MuseuFuncionamentoEntity create (MuseuFuncionamentoOutputDTO dto);

    MuseuFuncionamentoEntity findById(Long id);


}
