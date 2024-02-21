package adopet.apiadopet.entity;

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
}
