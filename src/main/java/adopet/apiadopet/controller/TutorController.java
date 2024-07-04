package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.AtualizarTutorRequest;
import adopet.apiadopet.dto.request.CriarTutorRequest;
import adopet.apiadopet.dto.response.MostrarTutorResponse;
import adopet.apiadopet.service.TutorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearer-key")
public class TutorController {

    @Autowired
    private TutorService service;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid CriarTutorRequest criarTutorRequest, UriComponentsBuilder uriBuilder) {
        return service.criar(criarTutorRequest, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<MostrarTutorResponse>> listarTodosOsTutores(@PageableDefault Pageable pageable) {
        return service.listarTodosOsTutores(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarTutorPorId(@PathVariable Long id) {
        return service.listarTutorPorId(id);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarTutorRequest atualizarTutorRequest) {
        return service.atualizar(atualizarTutorRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}
