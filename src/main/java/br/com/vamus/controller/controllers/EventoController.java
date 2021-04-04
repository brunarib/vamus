package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.entities.EventoEntity;
import br.com.vamus.services.interfaces.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping("/create")
    public EventoEntity create(@RequestBody @Valid EventoDTO dto){
        return service.create(dto);

    }

    @GetMapping("/")
    public List<EventoEntity> listEventos(){
        return  service.listEventosNow();
    }

    @GetMapping("/{inicio}/{fim}")
    public List<EventoEntity> listEventosByPeriod(@PathVariable LocalDateTime inicio
            , @PathVariable LocalDateTime fim ){
        return  service.listEventosByPeriod(inicio,fim);
    }

    @GetMapping("/{id}")
    public EventoEntity findById(@PathVariable Long id){
        return service.findById(id);
    }

}
