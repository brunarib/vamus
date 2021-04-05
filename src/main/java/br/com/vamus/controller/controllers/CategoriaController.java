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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.POST)
    public CategoriaEntity create(@RequestBody @Valid CategoriaDTO dto) throws IOException {
        return service.create(dto);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> listCategorias(){
        List<CategoriaEntity> list = service.listCategorias();
        return  new ResponseEntity<>(list.stream().map(CategoriaDTO::new)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<List<CategoriaDTO>>> listCategoriasPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws JsonProcessingException {
            Pageable pageable = PageRequest.of(page, size);
            return new ResponseEntity<>(service.listCategoriasPaged(
                    pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getMib(@PathVariable Long id) {
        CategoriaEntity entity = service.findById(id);
        return new ResponseEntity<>(new CategoriaDTO(entity), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteCategoria(id);
    }

}
