package adopet.apiadopet.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CriarAdocaoRequest(
        @NotNull
        @JsonAlias("pet")
        Long idPet,

        @NotNull
        @JsonAlias("tutor")
        Long idTutor,

        @NotNull
        @JsonFormat(pattern="dd/MM/yyyy")
        LocalDate data) {
}
