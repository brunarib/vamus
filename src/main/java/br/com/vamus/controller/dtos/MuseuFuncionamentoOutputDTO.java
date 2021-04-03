package br.com.vamus.controller.dtos;


import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class MuseuFuncionamentoOutputDTO {

    private UUID id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Boolean domingo;
    private Boolean segunda;
    private Boolean terca;
    private Boolean quarta;
    private Boolean quinta;
    private Boolean sexta;
    private Boolean sabado;






}
