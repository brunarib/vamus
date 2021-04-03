package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.TematicaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.TematicaEntity;
import br.com.vamus.services.interfaces.CategoriaService;
import br.com.vamus.services.interfaces.TematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tematicas")
public class TematicaController {

    @Autowired
    private TematicaService service;

    @PostMapping("/create")
    public TematicaEntity create(@RequestBody @Valid TematicaDTO dto){
        return service.create(dto);

    }

    @GetMapping("/")
    public List<TematicaEntity> listTematicas(){
        return  service.listTematicas();
    }

    @GetMapping("/{id}")
    public TematicaEntity findById(@PathVariable Long id){
        return service.findById(id);
    }

}
