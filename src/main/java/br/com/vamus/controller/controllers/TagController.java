package br.com.vamus.controller.controllers;


import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.controller.dtos.TagDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.TagEntity;
import br.com.vamus.services.interfaces.CategoriaService;
import br.com.vamus.services.interfaces.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService service;

    @PostMapping("/create")
    public TagEntity create(@RequestBody @Valid TagDTO dto){
        return service.create(dto);

    }

    @GetMapping("/")
    public List<TagEntity> listTags(){
        return  service.listTags();
    }

    @GetMapping("/{id}")
    public TagEntity findById(@PathVariable Long id){
        return service.findById(id);
    }

}
