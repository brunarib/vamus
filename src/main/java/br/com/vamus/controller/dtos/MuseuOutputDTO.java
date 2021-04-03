package br.com.vamus.controller.dtos;

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
@Builder
public class MuseuOutputDTO {

    private UUID id;
    private LocalDateTime CreatedAt;
    private LocalDateTime updatedAt;
    private String nome;
    private String decricao;
    private String endereco;
    private Long   latitude;
    private Long   longitude;
    private CategoriaDTO categoria;
    private List<EventoDTO> eventosList;
    private MuseuFuncionamentoOutputDTO funcionamento;

}
