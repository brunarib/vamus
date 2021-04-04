package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.MuseuFuncionamentoOutputDTO;
import br.com.vamus.entities.MuseuFuncionamentoEntity;
import br.com.vamus.respositories.MuseuFuncionamentoRepository;
import br.com.vamus.services.interfaces.MuseuFuncionamentoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MuseuFuncionamentoServiceImpl implements MuseuFuncionamentoService {


    private final MuseuFuncionamentoRepository repository;

    public MuseuFuncionamentoServiceImpl(MuseuFuncionamentoRepository repository) {
        this.repository = repository;
    }


    @Override
    public MuseuFuncionamentoEntity create(MuseuFuncionamentoOutputDTO dto) {
        MuseuFuncionamentoEntity entity = new MuseuFuncionamentoEntity();
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return this.repository.save(entity);
    }

    @Override
    public MuseuFuncionamentoEntity findById(Long id) {
        return this.repository.getOne(id);
    }


}
