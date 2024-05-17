package adopet.apiadopet.dto.response;

import adopet.apiadopet.entity.Abrigo;

public record MostrarAbrigoResponse(
        Long id,
        String nome,
        String telefone,
        String role) {

    public MostrarAbrigoResponse(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone(), abrigo.getRoles().get(1).getNome());
    }
}
