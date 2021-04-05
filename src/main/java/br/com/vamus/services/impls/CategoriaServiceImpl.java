package br.com.vamus.services.impls;

import br.com.vamus.controller.dtos.CategoriaDTO;
import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.ImagensEntity;
import br.com.vamus.respositories.CategoriaRepository;
import br.com.vamus.respositories.ImagensRepository;
import br.com.vamus.services.interfaces.CategoriaService;
import br.com.vamus.util.ImagemUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
  
    private ImagemUtil imagemUtil;

    private final ImagensRepository imagensRepository;
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(ImagensRepository imagensRepository, CategoriaRepository repository) {
      this.imagensRepository = imagensRepository;
      this.repository = repository;
    }


    @Override
    public List<CategoriaEntity> listCategorias() {
       return  repository.findAll();
     }

    @Override
    public CategoriaEntity create(CategoriaDTO dto) throws IOException {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNome(dto.getNome());
        if(dto.getImagemDTO() !=null){
        ImagensEntity img = new ImagensEntity();
        img.setNome(dto.getImagemDTO().getNome());
        img.setDescricao(dto.getImagemDTO().getDescricao());
        img.setPath(Base64.encodeBase64(dto.getImagemDTO().getPath().getBytes(StandardCharsets.UTF_8)));
        ImagensEntity savedImg =imagensRepository.save(img);
        entity.setImagemId(savedImg);}
        return repository.save(entity);
    }

    @Override
    public CategoriaEntity findById(Long id) {
        return repository.getOne(id);
    }


    @Override
    public Page<List<CategoriaDTO>> listCategoriasPaged(Pageable pageable) throws JsonProcessingException {

        Page pagCommissioned = repository.findAll(
                pageable);
        List<CategoriaEntity> entityList = pagCommissioned.getContent();
        List<CategoriaDTO> categorias =
                entityList.stream().map(CategoriaDTO::new).collect(Collectors.toList());

        Page page = new PageImpl<>(categorias);
        return page;
    }


    @Override
    public void deleteCategoria(Long id) {
        CategoriaEntity entity =
                repository.findById(id).orElseThrow(() -> new RuntimeException("não encontrado!"));
        entity.setDeleted(true);
        repository.save(entity);

    }
    
    public ImagensEntity saveImagem(MultipartFile[] file,
                                    CategoriaDTO dto)throws IOException {
      ImagensEntity saved = null;
     
      for(MultipartFile e : file){
      System.out.println("Original Image Byte Size - " + e.getBytes().length);
      ImagensEntity img = new ImagensEntity();
      img.setNome(e.getName());
      img.setDescricao(dto.imagemDTO.getDescricao());
      img.setPath(e.getBytes());
      saved = img;
            
      }
      imagensRepository.save(saved);
      return saved;
    }

}
