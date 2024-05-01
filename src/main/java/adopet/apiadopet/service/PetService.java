package adopet.apiadopet.service;

import adopet.apiadopet.dto.request.AtualizarPetRequest;
import adopet.apiadopet.dto.request.CriarPetRequest;
import adopet.apiadopet.dto.response.MostrarPetResponse;
import adopet.apiadopet.entity.Pet;
import adopet.apiadopet.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PetService {

    @Autowired
    private static PetRepository repository;

    @Transactional
    public ResponseEntity criar(CriarPetRequest petRequest, UriComponentsBuilder uriBuilder) {

        var abrigo = AbrigoService.retornaAbrigo(petRequest.idAbrigo());
        var pet = new Pet(petRequest, abrigo);

        repository.save(pet);
        var petResponse = new MostrarPetResponse(pet);

        var uri = uriBuilder.path("/api/pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(petResponse);
    }

    public ResponseEntity<Page<MostrarPetResponse>> listarTodosOsPets(Pageable pageable) {
        var page = repository.findAll(pageable).map(MostrarPetResponse::new);

        if (page.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(page);
    }

    public ResponseEntity listarPetPorId(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var dtoResponse = new MostrarPetResponse(repository.getReferenceById(id));

        return ResponseEntity.ok(dtoResponse);
    }

    @Transactional
    public ResponseEntity atualizarPetPorId(Long id, AtualizarPetRequest atualizarPetRequest) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        if (!AbrigoService.existeAbrigo(atualizarPetRequest.idAbrigo())) {
            return ResponseEntity.notFound().build();
        }

        var pet = repository.getReferenceById(id);
        var abrigo = AbrigoService.retornaAbrigo(atualizarPetRequest.idAbrigo());

        pet.atualizar(atualizarPetRequest, abrigo);

        return ResponseEntity.ok(new MostrarPetResponse(pet));
    }

    @Transactional
    public ResponseEntity deletarPetPorId(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    public static Pet retornaPet(Long id) {
        return repository.getReferenceById(id);
    }
}
