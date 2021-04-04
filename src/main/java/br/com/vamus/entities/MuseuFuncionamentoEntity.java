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

    @Column(name = "deleted")
    protected  Boolean deleted;

    @PrePersist
    @SuppressWarnings("unused")
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
        deleted =false;
    }

    @PreUpdate
    @SuppressWarnings("unused")
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Column(name = "domingo")
    private Boolean  domingo;

    @Column(name = "segunda")
    private Boolean  segunda;

    @Column(name = "terca")
    private Boolean  terca;

    @Column(name = "quarta" )
    private Boolean  quarta;

    @Column(name = "quinta" )
    private Boolean  quinta;

    @Column(name = "sexta" )
    private Boolean  sexta;

    @Column(name = "sabado" )
    private Boolean  sabado;

    @Column(name = "inicio_funcionamento")
    private LocalTime iniFuncionameto;

    @Column(name = "fim_funcionamento")
    private LocalTime fimFuncionameto;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "museu_id")
    protected MuseuEntity museuId;


}
