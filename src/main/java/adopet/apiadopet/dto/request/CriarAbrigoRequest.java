package adopet.apiadopet.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CriarAbrigoRequest(
        @NotBlank
        String nome,
        @NotBlank
        String telefone) {
}
