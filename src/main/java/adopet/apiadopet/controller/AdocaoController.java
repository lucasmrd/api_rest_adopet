package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.CriarAdocaoRequest;
import adopet.apiadopet.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid CriarAdocaoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        return service.criar(dtoRequest, uriBuilder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable Long id) {
        return service.deletarPorId(id);
    }
}
