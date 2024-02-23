package adopet.apiadopet.entity;

import adopet.apiadopet.domain.pet.EnderecoPet;
import adopet.apiadopet.domain.pet.TamanhoPet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private int idade;
    private TamanhoPet porte;
    private String descricao;

    @Embedded
    private EnderecoPet endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abrigo")
    private Abrigo abrigo;
}










