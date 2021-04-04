package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.*;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.services.interfaces.CategoriaService;
import br.com.vamus.services.interfaces.MuseuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/museus")
public class MuseuController {

    @Autowired
    private MuseuService service;

    @RequestMapping(method = RequestMethod.POST)
      public MuseuEntity create(@RequestBody @Valid MuseuInputDTO dto) throws Exception {
        return service.create(dto);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MuseuOutputDTO>> listMuseus(){
       return new ResponseEntity<>(service.listMuseus(), HttpStatus.OK);
    }


    @GetMapping("/paged")
    public ResponseEntity<Page<List<MuseuOutputDTO>>> listMuseusPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws JsonProcessingException {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(service.findMuseus(
                pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuseuDetalhesOutputDTO>findById(@PathVariable Long id) throws Exception {
        MuseuEntity entity = service.findById(id);
        return new ResponseEntity<>(new MuseuDetalhesOutputDTO(entity,
                service.findFuncionamentoByMuseuId(id)),
                HttpStatus.OK);
    }

    @GetMapping("/{dia}/allOpenNow")
    public ResponseEntity<List<MuseuDetalhesOutputDTO>>listAllOpenNow(@PathVariable String dia) throws Exception {
        List<MuseuDetalhesOutputDTO>list = service.listByFuncionamento(dia);
        return new ResponseEntity<>(list,
                HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteMuseu(id);
    }
}
