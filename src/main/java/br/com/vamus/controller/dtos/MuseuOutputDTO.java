package br.com.vamus.controller.dtos;

import br.com.vamus.entities.CategoriaEntity;
import br.com.vamus.entities.MuseuEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MuseuOutputDTO {

    public Long id;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public String nome;
    public String decricao;
    public String endereco;
    public String   latitude;
    public String   longitude;
    public CategoriaDTO categoria;


    public MuseuOutputDTO(MuseuEntity museuEntity) {

        this.id=museuEntity.getId();
        this.createdAt=museuEntity.getCreatedAt();
        this.updatedAt=museuEntity.getUpdatedAt();
        this.nome=museuEntity.getNome();
        this.decricao=museuEntity.getDescricao();
        this.endereco=museuEntity.getEndereco();
        this.latitude=museuEntity.getLatitude();
        this.longitude=museuEntity.getLongitude();
        this.categoria= new CategoriaDTO(museuEntity.getCategoria());
    }


}
