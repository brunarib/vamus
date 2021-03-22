package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.respositories.CategoriaRepository;
import br.com.vamus.services.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return this.repository.save(entity);
    }

    @Override
    public CategoriaEntity findById(Integer id) {
        return this.repository.findById(id);
    }


}
