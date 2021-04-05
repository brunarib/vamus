package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.*;
import br.com.vamus.entities.MuseuEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MuseuService {

  List<MuseuOutputDTO> listMuseus();

  Page<List<MuseuOutputDTO>> findMuseus(Pageable pageable, Optional<Long> categoryId) throws JsonProcessingException;

  MuseuEntity create(MuseuInputDTO dto) throws Exception;

  MuseuEntity findById(Long id) throws Exception;

  MuseuFuncionamentoOutputDTO findFuncionamentoByMuseuId(Long Id);

  List<MuseuDetalhesOutputDTO> listByFuncionamento(String dia);


  MuseuOutputDTO update(Long id, MuseuInputDTO museuInputDTO);

  void deleteMuseu(Long id);

  List<ImagemDTO> listImgByMuseuId(Long id);

  Page<List<MuseuOutputDTO>> findMuseusNether(String latitude,
                                                     String longitude,
                                                     int km,
                                                     Pageable pageable)
    throws JsonProcessingException;

}
