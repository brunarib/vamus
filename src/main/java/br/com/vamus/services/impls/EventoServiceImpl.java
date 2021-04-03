package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.entities.EventoEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.respositories.EventoRepository;
import br.com.vamus.respositories.MuseuRepository;
import br.com.vamus.services.interfaces.EventoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    private  final MuseuRepository museuRepository;
    private final EventoRepository repository;

    public EventoServiceImpl( MuseuRepository museuRepository, EventoRepository repository) {

        this.museuRepository = museuRepository;
        this.repository = repository;
    }


    @Override
    public List<EventoEntity> listEventos() {
       return  this.repository.findAll();
     }


    public EventoEntity create(EventoDTO dto) {
        EventoEntity entity = new EventoEntity();

        entity.setNome(dto.getNome());
        entity.setIniEvento(dto.getInicio());
        entity.setFimEvento(dto.getFim());
        entity.setDescricao(dto.getDescricao());
        entity.setGratuito(dto.getGratuito());
        entity.setValor(dto.getValor());

        MuseuEntity museuEntity =
                museuRepository.findById(dto.getMuseu().getId()).get();

        entity.setMuseuEntity(museuEntity);


        return this.repository.save(entity);
    }

    @Override
    public EventoEntity findById(Long id) {
        return this.repository.getOne(id);
    }


}
