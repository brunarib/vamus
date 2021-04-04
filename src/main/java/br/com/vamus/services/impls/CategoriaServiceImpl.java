package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.MuseuOutputDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.respositories.CategoriaRepository;
import br.com.vamus.services.interfaces.CategoriaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<CategoriaEntity> listCategorias() {
       return  repository.findAll();
     }

    @Override
    public CategoriaEntity create(CategoriaDTO dto) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNome(dto.getNome());
        return repository.save(entity);
    }

    @Override
    public CategoriaEntity findById(Long id) {
        return repository.getOne(id);
    }


    @Override
    public Page<List<CategoriaDTO>> listCategoriasPaged(Pageable pageable) throws JsonProcessingException {

        Page pagCommissioned = repository.findAll(
                pageable);
        List<CategoriaEntity> entityList = pagCommissioned.getContent();
        List<CategoriaDTO> categorias =
                entityList.stream().map(CategoriaDTO::new).collect(Collectors.toList());

        Page page = new PageImpl<>(categorias);
        return page;
    }



}
