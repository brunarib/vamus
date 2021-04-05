package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.*;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.ImagensEntity;
import br.com.vamus.entities.MuseuEntity;
import br.com.vamus.entities.MuseuFuncionamentoEntity;
import br.com.vamus.respositories.CategoriaRepository;
import br.com.vamus.respositories.ImagensRepository;
import br.com.vamus.respositories.MuseuFuncionamentoRepository;
import br.com.vamus.respositories.MuseuRepository;

import br.com.vamus.services.interfaces.MuseuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MuseuServiceImpl implements MuseuService {

  /* private final static MuseuMapper museuMapper = MuseuMapper.INSTANCE; */
  private final ImagensRepository imagensRepository;
  private final MuseuRepository museuRepository;
  private final CategoriaRepository categoriaRepository;
  private final MuseuFuncionamentoRepository museuFuncionamentoRepository;

  public MuseuServiceImpl(ImagensRepository imagensRepository, MuseuRepository museuRepository, CategoriaRepository categoriaRepository,
                          MuseuFuncionamentoRepository museuFuncionamentoRepository) {
    this.imagensRepository = imagensRepository;

    this.museuRepository = museuRepository;
    this.categoriaRepository = categoriaRepository;
    this.museuFuncionamentoRepository = museuFuncionamentoRepository;
  }

  /*
   * @Override public List<MuseuEntity> listMuseus() { return
   * this.museuRepository.findAll(); }
   */

  @Override
  public MuseuEntity create(MuseuInputDTO dto) throws Exception {

    CategoriaEntity categoriaEntity = categoriaRepository.findCategoriaById(dto.getCategoria().getId());
    
    if (categoriaEntity == null) {

      throw new RuntimeException("Categoria não encontrada!");
    }

    MuseuEntity entity = new MuseuEntity();
    entity.setCreatedAt(LocalDateTime.now());
    entity.setUpdatedAt(LocalDateTime.now());
    entity.setDeleted(false);
    entity.setNome(dto.getNome());
    entity.setEndereco(dto.getEndereco());
    entity.setTelefone(dto.getTelefone());
    entity.setSite(dto.getSite());
    entity.setValor(dto.getValor());
    entity.setDescricao(dto.getDecricao());
    entity.setLatitude(dto.getLatitude());
    entity.setLongitude(dto.getLongitude());
    entity.setCategoria(categoriaEntity);
    if(dto.getImagemDTOS() !=null || !dto.getImagemDTOS().isEmpty()){
    List<ImagensEntity> listImagens = new ArrayList<>();
      for(ImagemDTO e :dto.getImagemDTOS()){
        ImagensEntity img = new ImagensEntity();
        img.setNome(e.getNome());
        img.setDescricao(e.getDescricao());
        img.setPath(Base64.encodeBase64(e.getPath().getBytes(StandardCharsets.UTF_8)));
        ImagensEntity saved = imagensRepository.save(img);
        
        listImagens.add(saved);
      }
    entity.setImagens(listImagens);}
    MuseuEntity saved = museuRepository.save(entity);
    
    

    // funcionamento
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
  public MuseuEntity findById(Long id) throws Exception {
    MuseuEntity entity = museuRepository.findById(id).get();
    if (entity == null) {

      throw new Exception("Museu não cadastrado!");

    }
    return entity;

  }

  @Override
  public List<MuseuOutputDTO> listMuseus() {

    List<MuseuEntity> list = museuRepository.findAll();

    List<MuseuOutputDTO> dtos = list.stream().map(MuseuOutputDTO::new).collect(Collectors.toList());
    return dtos;
  }

  @Override
  public Page<List<MuseuOutputDTO>> findMuseus(Pageable pageable, Optional<Long> categoryId)
      throws JsonProcessingException {

    Page<MuseuEntity> pagCommissioned;
    
    if(categoryId.isPresent()) {
      pagCommissioned = museuRepository.findByCategoriaId(pageable, categoryId.get());
    } else {
      pagCommissioned = museuRepository.findAll(pageable);
    }
    List<MuseuEntity> entityList = pagCommissioned.getContent();
    List<MuseuOutputDTO> museus = entityList.stream().map(MuseuOutputDTO::new).collect(Collectors.toList());

    Page page = new PageImpl<>(museus);
    return page;
  }

  @Override
  public MuseuFuncionamentoOutputDTO findFuncionamentoByMuseuId(Long id) {
    MuseuFuncionamentoEntity entity = museuFuncionamentoRepository.findFuncionamentoByMuseuId(id);
    return new MuseuFuncionamentoOutputDTO(entity);
  }

  @Override
  public List<MuseuDetalhesOutputDTO> listByFuncionamento(String dia) {
    List<MuseuDetalhesOutputDTO> dtos = museuFuncionamentoRepository.findByFuncionamentoNow(dia);
    return dtos;
  }

  @Override
  public void deleteMuseu(Long id) {
    MuseuEntity entity = museuRepository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado!"));
    entity.setDeleted(true);
    museuRepository.save(entity);

  }
  
  @Override
    public MuseuOutputDTO update(Long id, MuseuInputDTO museuInputDTO){

      MuseuOutputDTO museu = new MuseuOutputDTO();
      Optional<MuseuEntity> oldMuseu = museuRepository.findById(id);
      
      if(oldMuseu.isPresent()){
        
      
        MuseuEntity entity = oldMuseu.get();
        entity.setNome(museuInputDTO.getNome());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setDeleted(false);
        entity.setNome(museuInputDTO.getNome());
        entity.setEndereco(museuInputDTO.getEndereco());
        entity.setEndereco(museuInputDTO.getEndereco());
        entity.setTelefone(museuInputDTO.getTelefone());
        entity.setValor(museuInputDTO.getValor());
        entity.setDescricao(museuInputDTO.getDecricao());
        entity.setLatitude(museuInputDTO.getLatitude());
        entity.setLongitude(museuInputDTO.getLongitude());

        CategoriaEntity categoriaEntity =
          categoriaRepository.findCategoriaById(museuInputDTO.getCategoria().getId());
        entity.setCategoria(categoriaEntity);

        MuseuEntity saved = museuRepository.saveAndFlush(entity);
          
        MuseuFuncionamentoEntity FuncionamentoOld =
          museuFuncionamentoRepository.findFuncionamentoByMuseuId(museuInputDTO.getId());
        //funcionamento
        MuseuFuncionamentoEntity museuFuncionamentoEntity = FuncionamentoOld;
        museuFuncionamentoEntity.setMuseuId(saved);
        museuFuncionamentoEntity.setIniFuncionameto(museuInputDTO.getFuncionamento().getInicio());
        museuFuncionamentoEntity.setFimFuncionameto(museuInputDTO.getFuncionamento().getFim());
        museuFuncionamentoEntity.setDomingo(museuInputDTO.getFuncionamento().getDomingo());
        museuFuncionamentoEntity.setSegunda(museuInputDTO.getFuncionamento().getSegunda());
        museuFuncionamentoEntity.setTerca(museuInputDTO.getFuncionamento().getTerca());
        museuFuncionamentoEntity.setQuarta(museuInputDTO.getFuncionamento().getQuarta());
        museuFuncionamentoEntity.setQuinta(museuInputDTO.getFuncionamento().getQuinta());
        museuFuncionamentoEntity.setSexta(museuInputDTO.getFuncionamento().getSexta());
        museuFuncionamentoEntity.setSabado(museuInputDTO.getFuncionamento().getSabado());
        museuFuncionamentoRepository.save(museuFuncionamentoEntity);

        museu= new MuseuOutputDTO(saved);
      }
      return museu;
    }
    
    @Override
    public List<ImagemDTO> listImgByMuseuId(Long id){
      List<ImagemDTO> dtos = new ArrayList<>();
    List<ImagensEntity>  imgList = imagensRepository.findByMuseuId(id);
    for(ImagensEntity e : imgList){
      dtos.add(new ImagemDTO(e));
    }
    return dtos;
    }

  @Override
  public List<MuseuOutputDTO> findMuseusAround(String latitude,
                                                     String longitude,
                                                     int km)
    throws JsonProcessingException {

    List<MuseuEntity> pagCommissioned;

    
      pagCommissioned = museuRepository.findAroundMuseus(latitude,longitude,km);
    
    
    List<MuseuOutputDTO> museus = pagCommissioned.stream().map(MuseuOutputDTO::new).collect(Collectors.toList());

    
    return museus;
  }

}
