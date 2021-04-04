package br.com.vamus.controller.dtos;

import br.com.vamus.entities.CategoriaEntity;
import lombok.*;

import java.time.LocalDateTime;



@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO {

    public Long id;
    public String nome;


    public CategoriaDTO(CategoriaEntity entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

}
