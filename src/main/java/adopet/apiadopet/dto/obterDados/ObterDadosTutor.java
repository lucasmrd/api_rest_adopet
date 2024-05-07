package adopet.apiadopet.dto.obterDados;

import adopet.apiadopet.entity.Tutor;
import adopet.apiadopet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObterDadosTutor {

    @Autowired
    private TutorRepository repository;

    public Tutor get(Long id) {
        return repository.getReferenceById(id);
    }
}
