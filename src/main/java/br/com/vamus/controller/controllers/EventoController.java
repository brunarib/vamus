package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.EventoDTO;
import br.com.vamus.controller.dtos.EventoOutputDTO;
import br.com.vamus.controller.dtos.MuseuOutputDTO;
import br.com.vamus.entities.EventoEntity;
import br.com.vamus.services.interfaces.EventoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EventoOutputDTO> create(@RequestBody @Valid EventoDTO dto){
        return new ResponseEntity<>( service.create(dto),HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventoOutputDTO>>listEventos(@RequestParam(required = false) Optional<Long> museuId){
        return new ResponseEntity<>( service.listEventosNow(museuId),HttpStatus.CREATED);
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<List<EventoOutputDTO>>>listEventosPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws JsonProcessingException {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(service.listEventosNowPaged(
                pageable), HttpStatus.OK);
    }



    @GetMapping("/{inicio}/{fim}")
    public List<EventoOutputDTO> listEventosByPeriod(@PathVariable String inicio
            , @PathVariable String fim ){
        return  service.listEventosByPeriod(LocalDateTime.parse(inicio, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse(fim, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoOutputDTO> findById(@PathVariable Long id){
        EventoOutputDTO dto= service.findById(id);
        return new ResponseEntity<>( dto,HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteEvento(id);
    }

}
