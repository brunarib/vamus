package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {

    List<CategoriaEntity> listCategorias();

    CategoriaEntity create (CategoriaDTO dto);

    CategoriaEntity findById(Long id);

    Page<List<CategoriaDTO>> listCategoriasPaged(Pageable pageable) throws JsonProcessingException ;


}
