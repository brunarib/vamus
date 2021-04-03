package br.com.vamus.controller.dtos;

import br.com.vamus.entities.CategoriaEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class TagDTO {

    private UUID id;
    private String nome;



}
