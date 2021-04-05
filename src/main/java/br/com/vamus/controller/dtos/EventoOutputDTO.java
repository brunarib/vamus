package br.com.vamus.controller.dtos;


import br.com.vamus.entities.EventoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoOutputDTO {

    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime inicio;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fim;
    private String nome;
    private String descricao;
    private Boolean gratuito;
    private Float valor;
    private Long museuId;
    private String museuNome;
    private ImagemDTO imagemDTO;


    public EventoOutputDTO(EventoEntity eventoEntity) {
        this.id= eventoEntity.getId();
        this.inicio=eventoEntity.getIniEvento();
        this.fim=eventoEntity.getFimEvento();
        this.nome=eventoEntity.getNome();
        this.descricao=eventoEntity.getDescricao();
        this.gratuito=eventoEntity.getGratuito();
        this.valor=eventoEntity.getValor();
        this.museuId= eventoEntity.getMuseuEntity().getId();
        this.museuNome= eventoEntity.getMuseuEntity().getNome();
       this.imagemDTO = new ImagemDTO(eventoEntity.getImagemId());
    }
}
