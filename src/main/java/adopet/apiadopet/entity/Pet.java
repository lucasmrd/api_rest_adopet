package adopet.apiadopet.entity;

import adopet.apiadopet.domain.pet.EnderecoPet;
import adopet.apiadopet.domain.pet.TamanhoPet;
import adopet.apiadopet.dto.request.AtualizarPetRequest;
import adopet.apiadopet.dto.request.CriarPetRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_pet")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String idade;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TamanhoPet porte;

    @Setter
    private Boolean adotado;
    private String imagem;

    @Embedded
    private EnderecoPet endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abrigo")
    private Abrigo abrigo;

    public Pet(CriarPetRequest petRequest, Abrigo abrigo) {
        this.abrigo = abrigo;
        this.nome = petRequest.nome();
        this.idade = petRequest.idade();
        this.porte = petRequest.porte();
        this.descricao = petRequest.descricao();
        this.endereco = petRequest.endereco();
        this.imagem = petRequest.imagem();
        this.adotado = false;
    }

    public void atualizar(AtualizarPetRequest att, Abrigo abrigo) {
        if (!(att.idAbrigo() == null)) {
            this.abrigo = abrigo;
        }

        if (!(att.nome() == null || att.nome().isEmpty() || att.nome().isBlank())) {
            this.nome = att.nome();
        }

        if (!(att.idade() == null || att.idade().isEmpty() || att.idade().isBlank())) {
            this.idade = att.idade();
        }

        if (!(att.descricao() == null || att.descricao().isEmpty() || att.descricao().isBlank())) {
            this.descricao = att.descricao();
        }

        if (!(att.adotado() == null)) {
            this.adotado = att.adotado();
        }

        if (!(att.imagem() == null || att.imagem().isEmpty() || att.imagem().isBlank())) {
            this.imagem = att.imagem();
        }

        if (!(att.porte() == null)) {
            this.porte = att.porte();
        }

        if (!(att.endereco() == null)) {
            this.endereco = att.endereco();
        }
    }
}










