package br.com.vamus.entities;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_delete is false")
@Table(name = "museu_funcionamento")
@Entity
public class MuseuFuncionamentoEntity {

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

    @Column(name = "domingo", insertable = false)
    private Boolean  domingo;

    @Column(name = "segunda",insertable = false)
    private Boolean  segunda;

    @Column(name = "terca", insertable = false)
    private Boolean  terca;

    @Column(name = "quarta", insertable = false)
    private Boolean  quarta;

    @Column(name = "quinta", insertable = false)
    private Boolean  quinta;

    @Column(name = "sexta", insertable = false)
    private Boolean  sexta;

    @Column(name = "sabado", insertable = false)
    private Boolean  sabado;

    @Column(name = "inicio_funcionamento")
    private LocalTime iniFuncionameto;

    @Column(name = "fim_funcionamento")
    private LocalTime fimFuncionameto;

    @OneToOne
    @JoinColumn(name = "museu_id")
    protected MuseuEntity museuId;


}
