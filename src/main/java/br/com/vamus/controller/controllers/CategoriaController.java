package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.services.interfaces.CategoriaService;
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
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/create")
    public CategoriaEntity create(@RequestBody @Valid CategoriaDTO dto){
        return service.create(dto);

    }

    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> listCategorias(){
        List<CategoriaEntity> list = service.listCategorias();
        return  new ResponseEntity<>(list.stream().map(CategoriaDTO::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<List<CategoriaDTO>>> listCategoriasPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws JsonProcessingException {
            Pageable pageable = PageRequest.of(page, size);
            return new ResponseEntity<>(service.listCategoriasPaged(
                    pageable), HttpStatus.OK);
    }

   /* @GetMapping("/{id}")
    public CategoriaEntity findById(@PathVariable UUID id){
        return service.findById(id);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getMib(@PathVariable Long id) {
        CategoriaEntity entity = service.findById(id);
        return new ResponseEntity<>(new CategoriaDTO(entity), HttpStatus.OK);
    }

}
