package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/create")
    public CategoriaEntity create(@RequestBody @Valid CategoriaDTO dto){
        return service.create(dto);

    }

    @GetMapping("/categorias")
    public List<CategoriaEntity> listCategorias(){
        return  service.listCategorias();
    }

    @GetMapping("/")
    public CategoriaEntity findById(@RequestParam(value = "id") Integer id){
        return service.findById(id);
    }

}
