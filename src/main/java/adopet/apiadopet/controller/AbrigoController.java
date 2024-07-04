package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.AtualizarAbrigoRequest;
import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import adopet.apiadopet.dto.response.MostrarAbrigoResponse;
import adopet.apiadopet.service.AbrigoService;
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
@RequestMapping("/api/abrigo")
@SecurityRequirement(name = "bearer-key")
public class AbrigoController {

    @Autowired
    private AbrigoService service;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid CriarAbrigoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        return service.criar(dtoRequest, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<MostrarAbrigoResponse>> listarTodosOsAbrigos(@PageableDefault Pageable pageable) {
        return service.listarTodosOsAbrigos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarAbrigoPorId(@PathVariable Long id) {
        return service.listarAbrigoPorId(id);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarAbrigoRequest atualizarAbrigoRequest) {
        return service.atualizar(atualizarAbrigoRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        return service.excluir(id);
    }
}
