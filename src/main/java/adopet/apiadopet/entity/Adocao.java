package adopet.apiadopet.entity;

import adopet.apiadopet.dto.request.CriarAdocaoRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "t_adocao")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    public Adocao(CriarAdocaoRequest dtoRequest, Pet pet, Tutor tutor) {
        this.pet = pet;
        this.tutor = tutor;
        this.data = dtoRequest.data();
    }
}
