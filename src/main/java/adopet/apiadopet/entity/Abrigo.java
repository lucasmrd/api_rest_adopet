package adopet.apiadopet.entity;

import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_abrigo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;

    public Abrigo(CriarAbrigoRequest dtoRequest) {
        this.nome = dtoRequest.nome();
        this.telefone = dtoRequest.telefone();
    }
}