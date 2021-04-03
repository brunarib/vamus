package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.EventoEntity;
import br.com.vamus.respositories.EventoRepository;
import br.com.vamus.services.interfaces.EventoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventoServiceImpl implements EventoService {


    private final EventoRepository repository;

    public EventoServiceImpl(EventoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<EventoEntity> listEventos() {
       return  this.repository.findAll();
     }


    public EventoEntity create(EventoDTO dto) {
        EventoEntity entity = new EventoEntity();

        entity.setNome(dto.getNome());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return this.repository.save(entity);
    }

    @Override
    public EventoEntity findById(Long id) {
        return this.repository.getOne(id);
    }


}
