package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.TematicaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.TematicaEntity;
import br.com.vamus.respositories.TematicaRepository;
import br.com.vamus.services.interfaces.TematicaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TematicaServiceImpl implements TematicaService {


    private final TematicaRepository repository;

    public TematicaServiceImpl(TematicaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<TematicaEntity> listTematicas() {
       return  this.repository.findAll();
     }

    @Override
    public TematicaEntity create(TematicaDTO dto) {
        TematicaEntity entity = new TematicaEntity();

        entity.setNome(dto.getNome());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return this.repository.save(entity);
    }


    @Override
    public TematicaEntity findById(Long id) {
        return this.repository.getOne(id);
    }


}
