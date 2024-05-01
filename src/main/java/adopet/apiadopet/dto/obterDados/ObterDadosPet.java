package adopet.apiadopet.dto.obterDados;

import adopet.apiadopet.entity.Pet;
import adopet.apiadopet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObterDadosPet {

    @Autowired
    private PetRepository repository;

    public Pet get(Long id) {
        return repository.getReferenceById(id);
    }
}
