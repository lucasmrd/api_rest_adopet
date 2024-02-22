package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.CriarTutorRequest;
import adopet.apiadopet.dto.response.MostrarTutorResponse;
import adopet.apiadopet.entity.Tutor;
import adopet.apiadopet.repository.TutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid CriarTutorRequest criarTutorRequest, UriComponentsBuilder uriBuilder) {
        var tutor = new Tutor(criarTutorRequest);
        var dtoResponse = new MostrarTutorResponse(tutor);
        tutorRepository.save(tutor);

        var uri = uriBuilder.path("/api/tutor/{id}").buildAndExpand(tutor.getId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }

    @GetMapping("/tutores")
    public ResponseEntity<Page<MostrarTutorResponse>> listarTodosOsTutores(@PageableDefault Pageable pageable) {
        var page = tutorRepository.findAll(pageable).map(MostrarTutorResponse::new);

        if (page.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(page);
    }


}
