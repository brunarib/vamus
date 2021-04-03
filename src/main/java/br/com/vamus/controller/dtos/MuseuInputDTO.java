package br.com.vamus.controller.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MuseuInputDTO {

    private UUID id;
    private LocalDateTime CreatedAt;
    private LocalDateTime updatedAt;
    private String nome;
    private String decricao;
    private String endereco;
    private Long   latitude;
    private Long   longitude;
    private UUID  categoriaId;
    private UUID  tematicaId;
    private UUID  tagId;
    private MuseuFuncionamentoOutputDTO;




}
