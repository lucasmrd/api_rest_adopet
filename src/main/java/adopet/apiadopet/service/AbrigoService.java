package adopet.apiadopet.service;

import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import adopet.apiadopet.dto.response.MostrarAbrigoResponse;
import adopet.apiadopet.entity.Abrigo;
import adopet.apiadopet.repository.AbrigoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    @Transactional
    public ResponseEntity criar(CriarAbrigoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        var abrigo = new Abrigo(dtoRequest);
        var dtoResponse = new MostrarAbrigoResponse(abrigo);
        repository.save(abrigo);

        var uri = uriBuilder.path("/api/abrigo/{id}").buildAndExpand(abrigo.getId()).toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }
}
