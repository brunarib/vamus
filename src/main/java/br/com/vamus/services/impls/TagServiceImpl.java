package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.TagDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.TagEntity;
import br.com.vamus.respositories.TagRepository;
import br.com.vamus.services.interfaces.TagService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {


    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<TagEntity> listTags() {
       return  this.repository.findAll();
     }

    @Override
    public TagEntity create(TagDTO dto) {
        TagEntity entity = new TagEntity();

        entity.setNome(dto.getNome());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return this.repository.save(entity);
    }

    @Override
    public TagEntity findById(Long id) {
        return this.repository.getOne(id);
    }


}
