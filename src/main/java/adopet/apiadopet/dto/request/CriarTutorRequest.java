package adopet.apiadopet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CriarTutorRequest(
        @NotBlank
        String nome) {
}
