package br.com.vamus.entities;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted =false")
@Table(name = "museus")
@Entity
public class MuseuEntity {

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

    @Column(name = "nome")
    protected String nome;

    @Column(name = "descricao", columnDefinition="TEXT")
    protected String descricao;

    @Column(name = "endereco")
    protected String endereco;

    @Column(name = "valor")
    protected Float valor;

    @Column(name = "telefone")
    protected String telefone;

    @Column(name = "site")
    protected String site;

    @Column(name = "latitude")
    protected String latitude;

    @Column(name = "logitude")
    protected String longitude;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoria_id")
    protected CategoriaEntity categoria;


  @OneToMany(fetch = FetchType.LAZY,cascade = { CascadeType.MERGE,
    CascadeType.PERSIST })
  @JoinTable(name="museu_imagens", joinColumns=
    {@JoinColumn(name="museu_id")}, inverseJoinColumns=
    {@JoinColumn(name="imagem_id")})
  private List<ImagensEntity> Imagens;

}
