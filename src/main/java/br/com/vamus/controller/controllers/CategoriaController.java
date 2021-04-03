package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public List<CategoriaEntity> listCategorias(){
        return  service.listCategorias();
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