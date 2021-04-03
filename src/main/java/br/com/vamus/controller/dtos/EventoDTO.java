package br.com.vamus.controller.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class EventoDTO {

    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String nome;
    private String descricao;
    private Boolean gratuito;
    private Float valor;
    private MuseuInputDTO museu;







}
