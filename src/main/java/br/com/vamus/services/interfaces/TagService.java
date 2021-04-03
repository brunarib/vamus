package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.TagDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.TagEntity;

import java.util.List;
import java.util.UUID;

public interface TagService {

    List<TagEntity> listTags();

    TagEntity create (TagDTO dto);

    TagEntity findById(Long id);
}
