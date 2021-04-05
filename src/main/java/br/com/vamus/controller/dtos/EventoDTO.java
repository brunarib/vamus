package br.com.vamus.controller.dtos;


import br.com.vamus.entities.EventoEntity;
import br.com.vamus.entities.ImagensEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoDTO {

    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime inicio;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fim;
    private String nome;
    private String descricao;
    private Boolean gratuito;
    private Float valor;
    private MuseuOutputDTO museu;
    private ImagemDTO imagemDTO;


    public EventoDTO(EventoEntity eventoEntity) {
        this.id= eventoEntity.getId();
        this.inicio=eventoEntity.getIniEvento();
        this.fim=eventoEntity.getFimEvento();
        this.nome=eventoEntity.getNome();
        this.descricao=eventoEntity.getDescricao();
        this.gratuito=eventoEntity.getGratuito();
        this.valor=eventoEntity.getValor();
        this.museu= new MuseuOutputDTO(eventoEntity.getMuseuEntity());
        this.imagemDTO= new ImagemDTO( eventoEntity.getImagemId()) == null ? null: new ImagemDTO( eventoEntity.getImagemId());
    }
}
