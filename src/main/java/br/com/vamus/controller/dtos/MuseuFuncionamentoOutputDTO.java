package br.com.vamus.controller.dtos;


import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class MuseuFuncionamentoOutputDTO {

    private Long id;
    private LocalTime inicio;
    private LocalTime fim;
    private Boolean domingo;
    private Boolean segunda;
    private Boolean terca;
    private Boolean quarta;
    private Boolean quinta;
    private Boolean sexta;
    private Boolean sabado;






}
