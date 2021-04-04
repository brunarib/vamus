package br.com.vamus.controller.dtos;

import br.com.vamus.entities.MuseuEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuseuOutputDTO {

    public Long id;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public String nome;
    public String decricao;
    public String endereco;
    public Float  valor;
    public String   latitude;
    public String   longitude;
    public CategoriaDTO categoria;
    public String telefone;
    public String site;


    public MuseuOutputDTO(MuseuEntity museuEntity) {

        this.id=museuEntity.getId();
        this.createdAt=museuEntity.getCreatedAt();
        this.updatedAt=museuEntity.getUpdatedAt();
        this.nome=museuEntity.getNome();
        this.decricao=museuEntity.getDescricao();
        this.valor=museuEntity.getValor();
        this.endereco=museuEntity.getEndereco();
        this.latitude=museuEntity.getLatitude();
        this.longitude=museuEntity.getLongitude();
        this.categoria= new CategoriaDTO(museuEntity.getCategoria());
        this.telefone=museuEntity.getTelefone();
        this.site=museuEntity.getSite();
    }


}
