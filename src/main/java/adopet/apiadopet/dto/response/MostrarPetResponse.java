package adopet.apiadopet.dto.response;

import adopet.apiadopet.domain.pet.EnderecoPet;
import adopet.apiadopet.domain.pet.TamanhoPet;
import adopet.apiadopet.entity.Pet;

public record MostrarPetResponse(
        Long idPet,
        Long idAbrigo,
        String nome,
        String idade,
        String descriacao,
        String imagem,
        Boolean adotado,
        TamanhoPet porte,
        EnderecoPet enderecoPet) {

    public MostrarPetResponse(Pet pet) {
        this(pet.getId(), pet.getAbrigo().getId(), pet.getNome(), pet.getIdade(),
                pet.getDescricao(), pet.getImagem(), pet.getAdotado(), pet.getPorte(), pet.getEndereco());
    }
}
