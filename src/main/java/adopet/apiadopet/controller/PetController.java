package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.AtualizarPetRequest;
import adopet.apiadopet.dto.request.CriarPetRequest;
import adopet.apiadopet.dto.response.MostrarPetResponse;
import adopet.apiadopet.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService service;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid CriarPetRequest petRequest, UriComponentsBuilder uriBuilder) {
        return service.criar(petRequest, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<MostrarPetResponse>> listarTodosOsPets(@PageableDefault Pageable pageable) {
        return service.listarTodosOsPets(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPetPorId(@PathVariable Long id) {
        return service.listarPetPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarPetPorId(@PathVariable Long id, AtualizarPetRequest atualizarPetRequest) {
        return service.atualizarPetPorId(id, atualizarPetRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPetPorId(@PathVariable Long id) {
        return service.deletarPetPorId(id);
    }
}












