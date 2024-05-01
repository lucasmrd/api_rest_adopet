package adopet.apiadopet.dto.request;

import adopet.apiadopet.domain.pet.EnderecoPet;
import adopet.apiadopet.domain.pet.TamanhoPet;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarPetRequest(
        @JsonAlias("abrigo_id")
        Long idAbrigo,
        String nome,
        String idade,
        String descricao,
        String imagem,
        TamanhoPet porte,
        EnderecoPet endereco) {
}
