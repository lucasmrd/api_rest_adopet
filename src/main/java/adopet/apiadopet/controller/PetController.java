package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.AtualizarPetRequest;
import adopet.apiadopet.dto.request.CriarPetRequest;
import adopet.apiadopet.dto.response.MostrarPetResponse;
import adopet.apiadopet.entity.Pet;
import adopet.apiadopet.repository.AbrigoRepository;
import adopet.apiadopet.repository.PetRepository;
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
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid CriarPetRequest petRequest,
                                UriComponentsBuilder uriBuilder) {

        var abrigo = abrigoRepository.getReferenceById(petRequest.idAbrigo());
        var pet = new Pet(petRequest, abrigo);

        petRepository.save(pet);
        var petResponse = new MostrarPetResponse(pet);

        var uri = uriBuilder.path("/api/pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(petResponse);
    }

    @GetMapping
    public ResponseEntity<Page<MostrarPetResponse>> listarTodosOsPets(@PageableDefault Pageable pageable) {
        var page = petRepository.findAll(pageable).map(MostrarPetResponse::new);

        if (page.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPetPorId(@PathVariable Long id) {

        if (!petRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var pet = petRepository.getReferenceById(id);
        var dtoResponse = new MostrarPetResponse(pet);

        return ResponseEntity.ok(dtoResponse);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarPetPorId(@PathVariable Long id, AtualizarPetRequest atualizarPet) {
        if (!petRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        if (!abrigoRepository.existsById(atualizarPet.idAbrigo())) {
            return ResponseEntity.notFound().build();
        }

        var pet = petRepository.getReferenceById(id);
        var abrigo = abrigoRepository.getReferenceById(atualizarPet.idAbrigo());

        pet.atualizar(atualizarPet, abrigo);

        var dtoResponse = new MostrarPetResponse(pet);

        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPetPorId(@PathVariable Long id) {
        if (!petRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        petRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}












