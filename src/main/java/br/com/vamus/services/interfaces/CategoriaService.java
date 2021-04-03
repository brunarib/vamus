package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {

    List<CategoriaEntity> listCategorias();

    CategoriaEntity create (CategoriaDTO dto);

    CategoriaEntity findById(Long id);
}
