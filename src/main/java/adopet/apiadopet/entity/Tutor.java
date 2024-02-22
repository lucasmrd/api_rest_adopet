package adopet.apiadopet.entity;

import adopet.apiadopet.dto.request.AtualizarTutorRequest;
import adopet.apiadopet.dto.request.CriarTutorRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_tutor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    public Tutor(CriarTutorRequest criarTutorRequest) {
        this.nome = criarTutorRequest.nome();
        this.email = criarTutorRequest.email();
        this.senha = criarTutorRequest.senha();
    }

    public void atualizar(AtualizarTutorRequest att) {
        if (!(att.nome() == null || att.nome().isEmpty() || att.nome().isBlank())) {
            this.nome = att.nome();
        }

        if (!(att.senha() == null || att.senha().isEmpty() || att.senha().isBlank())) {
            this.senha = att.senha();
        }
    }
}
