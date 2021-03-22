package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;

import java.util.List;

public interface CategoriaService {

    List<CategoriaEntity> listCategorias();

    CategoriaEntity create (CategoriaDTO dto);

    CategoriaEntity findById(Integer id);
}
