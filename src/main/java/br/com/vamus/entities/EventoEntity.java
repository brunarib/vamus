package br.com.vamus.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="eventos")
@Entity
public class EventoEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "museu_id")
    private MuseuEntity museuEntity;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tematica_id")
    private TematicaEntity tematica;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;

    @Column(name = "ini_evento")
    private LocalDateTime IniEvento;

    @Column(name = "fim_evento")
    private LocalDateTime FimEvento;

    @Column(name = "gratuito")
    private Boolean gratuito =true;

    @Column(name = "valor")
    private Float valor;

}
