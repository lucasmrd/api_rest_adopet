package adopet.apiadopet.dto.request;

import adopet.apiadopet.domain.pet.EnderecoPet;
import adopet.apiadopet.domain.pet.TamanhoPet;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarPetRequest(
        @NotNull
        @JsonAlias("abrigo_id")
        Long idAbrigo,

        @NotBlank
        String nome,

        @NotBlank
        String idade,

        @NotBlank
        String descricao,

        @NotNull
        TamanhoPet porte,

        @NotNull
        String imagem,

        @NotNull
        EnderecoPet endereco) {
}
