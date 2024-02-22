package adopet.apiadopet.dto.response;

import adopet.apiadopet.entity.Tutor;

public record MostrarTutorResponse(
        String nome,
        String email,
        String senha) {

    public MostrarTutorResponse(Tutor tutor) {
        this(tutor.getNome(), tutor.getEmail(), tutor.getSenha());
    }
}
