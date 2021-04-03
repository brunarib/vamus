package br.com.vamus.services.impls;


import br.com.vamus.controller.dtos.MuseuInputDTO;
import br.com.vamus.controller.dtos.mappers.MuseuMapper;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.entities.MuseuFuncionamentoEntity;
import br.com.vamus.respositories.MuseuFuncionamentoRepository;
import br.com.vamus.respositories.MuseuRepository;

import br.com.vamus.services.interfaces.MuseuService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MuseuServiceImpl implements MuseuService {

    /*private final static MuseuMapper museuMapper = MuseuMapper.INSTANCE;*/

    private final MuseuRepository museuRepository;
    private final MuseuFuncionamentoRepository museuFuncionamentoRepository;


    public MuseuServiceImpl(MuseuRepository museuRepository, MuseuFuncionamentoRepository museuFuncionamentoRepository) {

        this.museuRepository = museuRepository;
        this.museuFuncionamentoRepository = museuFuncionamentoRepository;
    }


    @Override
    public List<MuseuEntity> listMuseus() {
       return  this.museuRepository.findAll();
     }

    @Override
    public MuseuEntity create(MuseuInputDTO dto) {
        MuseuEntity entity = new MuseuEntity();
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return this.museuRepository.save(entity);
    }

    @Override
    public MuseuEntity findById(Long id) {
        return this.museuRepository.getOne(id);
    }


}
