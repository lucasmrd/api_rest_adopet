package adopet.apiadopet.service;

import adopet.apiadopet.dto.request.AtualizarAbrigoRequest;
import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import adopet.apiadopet.dto.response.MostrarAbrigoResponse;
import adopet.apiadopet.entity.Abrigo;
import adopet.apiadopet.repository.AbrigoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AbrigoService {

    @Autowired
    private static AbrigoRepository repository;

    @Transactional
    public ResponseEntity criar(CriarAbrigoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        var abrigo = new Abrigo(dtoRequest);
        var dtoResponse = new MostrarAbrigoResponse(abrigo);
        repository.save(abrigo);

        var uri = uriBuilder.path("/api/abrigo/{id}").buildAndExpand(abrigo.getId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }

    public ResponseEntity<Page<MostrarAbrigoResponse>> listarTodosOsAbrigos(Pageable pageable) {
        var page = repository.findAll(pageable).map(MostrarAbrigoResponse::new);

        if (page.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(page);
    }

    public ResponseEntity listarAbrigoPorId(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var dtoResponse = new MostrarAbrigoResponse(repository.getReferenceById(id));

        return ResponseEntity.ok(dtoResponse);
    }

    @Transactional
    public ResponseEntity atualizar(AtualizarAbrigoRequest atualizarAbrigoRequest) {
        var abrigo = repository.getReferenceById(atualizarAbrigoRequest.id());
        abrigo.atualizar(atualizarAbrigoRequest);

        return ResponseEntity.ok(new MostrarAbrigoResponse(abrigo));
    }

    @Transactional
    public ResponseEntity excluir(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public static Abrigo retornaAbrigo(Long id) {
        return repository.getReferenceById(id);
    }

    public static boolean existeAbrigo(Long id) {
        return repository.existsById(id);
    }
}
