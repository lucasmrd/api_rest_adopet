package adopet.apiadopet.dto.response;

import adopet.apiadopet.entity.Adocao;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record MostrarAdocaoResponse(
        Long idAdocao,
        Long idPet,
        Long idTutor,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data) {

    public MostrarAdocaoResponse(Adocao adocao) {
        this(adocao.getId(), adocao.getPet().getId(), adocao.getTutor().getId(), adocao.getData());
    }
}
