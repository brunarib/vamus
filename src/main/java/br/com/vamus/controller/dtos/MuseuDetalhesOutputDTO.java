package br.com.vamus.controller.dtos;

import br.com.vamus.controller.dtos.mappers.MuseuMapper;
import br.com.vamus.entities.MuseuEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuseuDetalhesOutputDTO {

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
    public MuseuFuncionamentoOutputDTO funcionamentoOutputDTO;
    public String telefone;
    public String site;
    public List<ImagemDTO> imagemDTOS;


    public MuseuDetalhesOutputDTO(MuseuEntity museuEntity,
                                  MuseuFuncionamentoOutputDTO funcionamentoOutputDTO,
      List<ImagemDTO> imagemDTOList
    ) {

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
        this.funcionamentoOutputDTO = funcionamentoOutputDTO;
        this.telefone = museuEntity.getTelefone();
        this.site = museuEntity.getSite();
        this.imagemDTOS = imagemDTOList;
    }


}
