package adopet.apiadopet.service;

import adopet.apiadopet.dto.request.AtualizarTutorRequest;
import adopet.apiadopet.dto.request.CriarTutorRequest;
import adopet.apiadopet.dto.response.MostrarTutorResponse;
import adopet.apiadopet.entity.Role;
import adopet.apiadopet.entity.Tutor;
import adopet.apiadopet.repository.RoleRepository;
import adopet.apiadopet.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public ResponseEntity criar(@RequestBody @Valid CriarTutorRequest criarTutorRequest, UriComponentsBuilder uriBuilder) {
        var tutor = new Tutor(criarTutorRequest, encoder.encode(criarTutorRequest.senha()));
        tutor.addRole(roleRepository.getReferenceById(1L));

        var dtoResponse = new MostrarTutorResponse(tutor);


        repository.save(tutor);

        var uri = uriBuilder.path("/api/tutor/{id}").buildAndExpand(tutor.getId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }

    public ResponseEntity<Page<MostrarTutorResponse>> listarTodosOsTutores(Pageable pageable) throws EntityNotFoundException {
        var page = repository.findAll(pageable).map(MostrarTutorResponse::new);

        if (page.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return ResponseEntity.ok(page);
    }

    public ResponseEntity listarTutorPorId(Long id) {
        var dtoResponse = new MostrarTutorResponse(repository.getReferenceById(id));

        return ResponseEntity.ok(dtoResponse);
    }

    @Transactional
    public ResponseEntity atualizar(AtualizarTutorRequest atualizarTutorRequest) {
        var tutor = repository.getReferenceById(atualizarTutorRequest.id());
        tutor.atualizar(atualizarTutorRequest);
        var dtoResponse = (new MostrarTutorResponse(tutor));

        return ResponseEntity.ok(dtoResponse);
    }

    @Transactional
    public ResponseEntity deletar(Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}