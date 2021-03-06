package br.com.vamus.controller.dtos;

import lombok.*;

import javax.swing.text.html.HTML;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MuseuInputDTO {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String nome;
    private String decricao;
    private String endereco;
    private Float  valor;
    private String   latitude;
    private String   longitude;
    private CategoriaDTO  categoria;
    private MuseuFuncionamentoOutputDTO funcionamento;




}
