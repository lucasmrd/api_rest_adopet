package adopet.apiadopet.dto.response;

import adopet.apiadopet.entity.Tutor;

public record MostrarTutorResponse(
        Long id,
        String nome) {

    public MostrarTutorResponse(Tutor tutor) {
        this(tutor.getId(), tutor.getNome());
    }
}
