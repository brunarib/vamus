package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.respositories.CategoriaRepository;
import br.com.vamus.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;


    @Override
    public List<CategoriaEntity> listCategorias() {
       return  this.repository.findAll();
     }

    @Override
    public CategoriaEntity create(CategoriaDTO dto) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNome(dto.getNome());
        return this.repository.save(entity);
    }

    @Override
    public CategoriaEntity findById(Long id) {
        return this.repository.getOne(id);
    }




}
