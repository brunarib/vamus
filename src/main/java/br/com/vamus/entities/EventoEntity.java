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
public class EventoEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    protected LocalDateTime updatedAt;

    @Column(name = "deleted", insertable = false)
    protected  Boolean deleted;

    @PrePersist
    @SuppressWarnings("unused")
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    @SuppressWarnings("unused")
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
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

    @Column(name = "gratuito", insertable = true)
    private Boolean gratuito;

    @Column(name = "valor")
    private Float valor;

}
