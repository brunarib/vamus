package br.com.vamus.controller.dtos;


import br.com.vamus.entities.MuseuFuncionamentoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class MuseuFuncionamentoOutputDTO {

    private Long id;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime inicio;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime fim;

    private Boolean domingo;
    private Boolean segunda;
    private Boolean terca;
    private Boolean quarta;
    private Boolean quinta;
    private Boolean sexta;
    private Boolean sabado;


    public MuseuFuncionamentoOutputDTO(MuseuFuncionamentoEntity entity) {

        this.id = entity.getId();
        this.inicio = entity.getIniFuncionameto();
        this.fim=entity.getFimFuncionameto();
        this.domingo=entity.getDomingo();
        this.segunda=entity.getSegunda();
        this.terca=entity.getTerca();
        this.quarta=entity.getQuarta();
        this.quinta=entity.getQuinta();
        this.sexta=entity.getSexta();
        this.sabado=entity.getSabado();
    }
}
