package adopet.apiadopet.entity;

import adopet.apiadopet.dto.request.AtualizarAbrigoRequest;
import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_abrigo")
@Getter
@Setter
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

    public void atualizar(AtualizarAbrigoRequest att) {
        if (!(att.nome() == null || att.nome().isEmpty() || att.nome().isBlank())) {
            this.nome = att.nome();
        }

        if (!(att.telefone() == null || att.telefone().isEmpty() || att.telefone().isBlank())) {
            this.telefone = att.telefone();
        }

    }
}