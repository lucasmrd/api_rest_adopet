package adopet.apiadopet.service;

import adopet.apiadopet.dto.obterDados.ObterDadosPet;
import adopet.apiadopet.dto.obterDados.ObterDadosTutor;
import adopet.apiadopet.dto.request.CriarAdocaoRequest;
import adopet.apiadopet.dto.response.MostrarAdocaoResponse;
import adopet.apiadopet.dto.response.MostrarPetResponse;
import adopet.apiadopet.entity.Adocao;
import adopet.apiadopet.repository.AdocaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository repository;
    @Autowired
    private ObterDadosTutor obterDadosTutor;
    @Autowired
    private ObterDadosPet obterDadosPet;

    @Transactional
    public ResponseEntity criar(CriarAdocaoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        var pet = obterDadosPet.get(dtoRequest.idPet());
        var tutor = obterDadosTutor.get(dtoRequest.idTutor());
        var adocao = new Adocao(dtoRequest, pet, tutor);
        repository.save(adocao);
        pet.setAdotado(true);

        var adocaoResponse = new MostrarAdocaoResponse(adocao);

        var uri = uriBuilder.path("/api/adocao/{id}").buildAndExpand(adocao.getId()).toUri();

        return ResponseEntity.created(uri).body(adocaoResponse);
    }

    public ResponseEntity<Page<MostrarAdocaoResponse>> listarTodasAdocoes(@PageableDefault Pageable pageable) {
        var page = repository.findAll(pageable).map(MostrarAdocaoResponse::new);

        if (page.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(page);
    }

    @Transactional
    public ResponseEntity deletarPorId(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var adocao = repository.getReferenceById(id);
        var pet = adocao.getPet();
        repository.deleteById(id);
        pet.setAdotado(false);

        return ResponseEntity.noContent().build();
    }
}
