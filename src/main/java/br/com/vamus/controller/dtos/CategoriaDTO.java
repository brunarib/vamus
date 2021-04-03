package br.com.vamus.controller.dtos;

import br.com.vamus.entities.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;
    private LocalDateTime CreatedAt;
    private LocalDateTime updatedAt;
    private String nome;


    public CategoriaDTO(CategoriaEntity entity){
        this.id = entity.getId();
        this.CreatedAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.nome = entity.getNome();
    }

}
