package adopet.apiadopet.controller;

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

}
