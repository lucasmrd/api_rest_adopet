package adopet.apiadopet.dto.response;

import adopet.apiadopet.entity.Abrigo;

public record MostrarAbrigoResponse(
        Long id,
        String nome,
        String telefone) {

    public MostrarAbrigoResponse(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone());
    }
}
