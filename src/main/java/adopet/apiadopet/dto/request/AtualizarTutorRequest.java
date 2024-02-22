package adopet.apiadopet.dto.request;

import jakarta.validation.constraints.NotNull;

public record AtualizarTutorRequest(
        @NotNull
        Long id,
        String nome,
        String senha) {
}
