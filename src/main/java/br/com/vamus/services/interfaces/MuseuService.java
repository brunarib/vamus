package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.MuseuDetalhesOutputDTO;
import br.com.vamus.controller.dtos.MuseuFuncionamentoOutputDTO;
import br.com.vamus.controller.dtos.MuseuInputDTO;
import br.com.vamus.controller.dtos.MuseuOutputDTO;
import br.com.vamus.entities.MuseuEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MuseuService {

    List<MuseuOutputDTO> listMuseus();

   Page<List<MuseuOutputDTO>> findMuseus(
                                      Pageable pageable) throws JsonProcessingException;


   MuseuEntity create (MuseuInputDTO dto) throws Exception;

   MuseuEntity findById(Long id) throws Exception;

   MuseuFuncionamentoOutputDTO findFuncionamentoByMuseuId(Long Id);

   List<MuseuDetalhesOutputDTO> listByFuncionamento(String dia);

   void deleteMuseu(Long id);
   
   MuseuOutputDTO update(Long id, MuseuOutputDTO museuOutputDTO);

  MuseuOutputDTO update(Long id, MuseuInputDTO museuInputDTO);
}
