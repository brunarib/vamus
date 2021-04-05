package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.controller.dtos.EventoOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<EventoOutputDTO> listEventos();

    EventoOutputDTO create (EventoDTO dto);

    EventoOutputDTO findById(Long id);

    Page<List<EventoOutputDTO>> listEventosNowPaged(Pageable pageable);

    List<EventoOutputDTO> listEventosNow(Optional<Long> museuId);

    List<EventoOutputDTO> listEventosByPeriod(LocalDateTime inicio, LocalDateTime fim);

    void deleteEvento(Long id);
}
