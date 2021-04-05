package br.com.vamus.controller.dtos;

import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.ImagensEntity;
import lombok.*;
import org.apache.tomcat.util.codec.binary.Base64;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImagemDTO {
  
  private Long id= null;
  private String nome= null;
  private String descricao= null;
  private String path= null;

  public ImagemDTO(ImagensEntity entity){
    if(entity!=null){
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.descricao=entity.getDescricao();
    byte [] decoder = Base64.decodeBase64(entity.getPath());
    this.path = new String(decoder);}
    
  }
  
}
