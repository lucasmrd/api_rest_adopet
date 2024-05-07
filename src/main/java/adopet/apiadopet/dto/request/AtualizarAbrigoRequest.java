package adopet.apiadopet.dto.request;

import jakarta.validation.constraints.NotNull;

public record AtualizarAbrigoRequest(
        @NotNull
        Long id,
        String nome,
        String telefone) {
}
