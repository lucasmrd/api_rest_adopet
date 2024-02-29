package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.AtualizarAbrigoRequest;
import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import adopet.apiadopet.dto.response.MostrarAbrigoResponse;
import adopet.apiadopet.entity.Abrigo;
import adopet.apiadopet.repository.AbrigoRepository;
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
@RequestMapping("/api/abrigo")
public class AbrigoController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid CriarAbrigoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        var abrigo = new Abrigo(dtoRequest);
        var dtoResponse = new MostrarAbrigoResponse(abrigo);
        abrigoRepository.save(abrigo);

        var uri = uriBuilder.path("/api/abrigo/{id}").buildAndExpand(abrigo.getId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }

    @GetMapping
    public ResponseEntity<Page<MostrarAbrigoResponse>> listarTodosOsAbrigos(@PageableDefault Pageable pageable) {
        var page = abrigoRepository.findAll(pageable).map(MostrarAbrigoResponse::new);

        if (page.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarAbrigoPorId(@PathVariable Long id) {
        if (!abrigoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var abrigo = abrigoRepository.getReferenceById(id);
        var dtoResponse = new MostrarAbrigoResponse(abrigo);

        return ResponseEntity.ok(dtoResponse);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarAbrigoRequest atualizarAbrigoRequest) {
        var abrigo = abrigoRepository.getReferenceById(atualizarAbrigoRequest.id());
        abrigo.atualizar(atualizarAbrigoRequest);
        var dtoResponse = new MostrarAbrigoResponse(abrigo);

        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        if (!abrigoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        abrigoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
