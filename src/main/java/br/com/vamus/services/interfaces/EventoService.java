package br.com.vamus.services.interfaces;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.EventoEntity;

import java.util.List;
import java.util.UUID;

public interface EventoService {

    List<EventoEntity> listEventos();

    EventoEntity create (EventoDTO dto);

    EventoEntity findById(Long id);
}
