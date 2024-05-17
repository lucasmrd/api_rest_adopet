package adopet.apiadopet.dto.response;

import adopet.apiadopet.entity.Role;
import adopet.apiadopet.entity.Tutor;

import java.util.List;

public record MostrarTutorResponse(
        Long id,
        String nome,
        String role) {

    public MostrarTutorResponse(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getRoles().get(0).getNome());
    }
}
