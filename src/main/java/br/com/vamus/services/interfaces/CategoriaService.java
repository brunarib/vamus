package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CategoriaService {

    List<CategoriaEntity> listCategorias();

    CategoriaEntity create (CategoriaDTO dto) throws IOException;

    CategoriaEntity findById(Long id);

    Page<List<CategoriaDTO>> listCategoriasPaged(Pageable pageable) throws JsonProcessingException ;

    void deleteCategoria(Long id);

}
