package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.MuseuFuncionamentoOutputDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuFuncionamentoEntity;
import br.com.vamus.services.interfaces.CategoriaService;
import br.com.vamus.services.interfaces.MuseuFuncionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionamentos")
public class MuseuFuncionamentoController {

  /*  @Autowired
    private MuseuFuncionamentoService service;

    @PostMapping("/create")
    public MuseuFuncionamentoOutputDTO create(@RequestBody @Valid MuseuFuncionamentoOutputDTO dto){
        return service.create(dto);

    }

    @GetMapping("/")
    public List<MuseuFuncionamentoOutputDTO> listCategorias(){
        return  service.();
    }

    @GetMapping("/{id}")
    public MuseuFuncionamentoOutputDTO findById(@PathVariable Long id){
        return service.findById(id);
    }*/

}
