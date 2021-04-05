package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.controller.dtos.EventoOutputDTO;
import br.com.vamus.entities.EventoEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.respositories.EventoRepository;
import br.com.vamus.respositories.MuseuRepository;
import br.com.vamus.services.interfaces.EventoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventoServiceImpl implements EventoService {

    private  final MuseuRepository museuRepository;
    private final EventoRepository repository;

    public EventoServiceImpl( MuseuRepository museuRepository, EventoRepository repository) {

        this.museuRepository = museuRepository;
        this.repository = repository;
    }


    @Override
    public  List<EventoOutputDTO>  listEventos() {
        List<EventoEntity> entityList = repository.findAll();
        List<EventoOutputDTO> list =
                entityList.stream().map(EventoOutputDTO::new).collect(Collectors.toList());
        return list;
     }

    @Override
    public EventoOutputDTO create(EventoDTO dto) {
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

        EventoEntity eventoEntity =  this.repository.save(entity);


        return new EventoOutputDTO(eventoEntity);
    }

    @Override
    public EventoOutputDTO findById(Long id) {
        EventoEntity eventoEntity =  this.repository.getOne(id);
        return new EventoOutputDTO(eventoEntity);
    }

    @Override
    public Page<List<EventoOutputDTO>> listEventosNowPaged(Pageable pageable) {
        Page pagNow = repository.findByDateNowPaged(pageable);

        List<EventoEntity> entityList = pagNow.getContent();

        List<EventoOutputDTO> list =
                entityList.stream().map(EventoOutputDTO::new).collect(Collectors.toList());
        Page page = new PageImpl<>(list);
        return page;
    }

    @Override
    public List<EventoOutputDTO> listEventosNow(Optional<Long> museuId) {
        List<EventoEntity> entityList = repository.findByDateNow();


        List<EventoOutputDTO>list;
        if(museuId.isPresent()) {
          list = entityList.stream()
            .filter(el -> el.getMuseuEntity().getId() == museuId.get())
            .map(EventoOutputDTO::new)
            .collect(Collectors.toList());
          return list;
        }
        
        list = entityList.stream()
          .map(EventoOutputDTO::new)
          .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<EventoOutputDTO> listEventosByPeriod(LocalDateTime inicio, LocalDateTime fim) {
        List<EventoEntity> entityList = repository.findByDate(inicio,fim);

        List<EventoOutputDTO> list =
                entityList.stream().map(EventoOutputDTO::new).collect(Collectors.toList());
        return list;
    }


    @Override
    public void deleteEvento(Long id) {
        EventoEntity entity =
                repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado!"));
        entity.setDeleted(true);
        repository.save(entity);
    }
}
