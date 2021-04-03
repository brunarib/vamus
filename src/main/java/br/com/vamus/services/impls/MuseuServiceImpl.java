package br.com.vamus.services.impls;


import br.com.vamus.controller.dtos.MuseuInputDTO;
import br.com.vamus.controller.dtos.MuseuOutputDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.entities.MuseuFuncionamentoEntity;
import br.com.vamus.respositories.CategoriaRepository;
import br.com.vamus.respositories.MuseuFuncionamentoRepository;
import br.com.vamus.respositories.MuseuRepository;

import br.com.vamus.services.interfaces.MuseuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MuseuServiceImpl implements MuseuService {

    /*private final static MuseuMapper museuMapper = MuseuMapper.INSTANCE;*/

    private final MuseuRepository museuRepository;
    private final CategoriaRepository categoriaRepository;
    private final MuseuFuncionamentoRepository museuFuncionamentoRepository;


    public MuseuServiceImpl(MuseuRepository museuRepository, CategoriaRepository categoriaRepository, MuseuFuncionamentoRepository museuFuncionamentoRepository) {

        this.museuRepository = museuRepository;
        this.categoriaRepository = categoriaRepository;
        this.museuFuncionamentoRepository = museuFuncionamentoRepository;
    }


    /*@Override
    public List<MuseuEntity> listMuseus() {
       return  this.museuRepository.findAll();
     }*/

    @Override
    public MuseuEntity create(MuseuInputDTO dto) {

        CategoriaEntity categoriaEntity =
                categoriaRepository.findById(dto.getCategoria().getId()).get();

        MuseuEntity entity = new MuseuEntity();
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setDeleted(false);
        entity.setNome(dto.getNome());
        entity.setEndereco(dto.getEndereco());
        entity.setDescricao(dto.getDecricao());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setCategoria(categoriaEntity);
        MuseuEntity saved = museuRepository.save(entity);

        //funcionamento
        MuseuFuncionamentoEntity museuFuncionamentoEntity = new MuseuFuncionamentoEntity();
        museuFuncionamentoEntity.setMuseuId(saved);
        museuFuncionamentoEntity.setIniFuncionameto(dto.getFuncionamento().getInicio());
        museuFuncionamentoEntity.setFimFuncionameto(dto.getFuncionamento().getFim());
        museuFuncionamentoEntity.setDomingo(dto.getFuncionamento().getDomingo());
        museuFuncionamentoEntity.setSegunda(dto.getFuncionamento().getSegunda());
        museuFuncionamentoEntity.setTerca(dto.getFuncionamento().getTerca());
        museuFuncionamentoEntity.setQuarta(dto.getFuncionamento().getQuarta());
        museuFuncionamentoEntity.setQuinta(dto.getFuncionamento().getQuinta());
        museuFuncionamentoEntity.setSexta(dto.getFuncionamento().getSexta());
        museuFuncionamentoEntity.setSabado(dto.getFuncionamento().getSabado());
        museuFuncionamentoRepository.save(museuFuncionamentoEntity);
        return saved;

    }

    @Override
    public MuseuEntity findById(Long id) {
        return this.museuRepository.findById(id).get();
    }


    @Override
    public List<MuseuEntity> listMuseus() {

        List<MuseuEntity> list =  museuRepository.findAll();
        return list;
    }

    @Override
    public Page<List<MuseuOutputDTO>> findMuseus(MuseuOutputDTO museuOutputDTO,
                                               Pageable pageable) throws JsonProcessingException {

        Page pagCommissioned = museuRepository.findAll(
                pageable);
        List<MuseuEntity> entityList = pagCommissioned.getContent();


        List<MuseuOutputDTO> museus =
                entityList.stream().map(MuseuOutputDTO::new).collect(Collectors.toList());

        Page page = new PageImpl<>(museus);
        return page;
    }



}
