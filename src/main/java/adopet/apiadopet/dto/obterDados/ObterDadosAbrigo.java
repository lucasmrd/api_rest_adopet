package adopet.apiadopet.dto.obterDados;

import adopet.apiadopet.entity.Abrigo;
import adopet.apiadopet.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObterDadosAbrigo {

    @Autowired
    private AbrigoRepository repository;

    public Abrigo get(Long id) {
        return repository.getReferenceById(id);
    }

    public boolean existeAbrigo(Long id) {
        return repository.existsById(id);
    }
}
