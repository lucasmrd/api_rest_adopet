package adopet.apiadopet.service;

import adopet.apiadopet.dto.request.CriarAdocaoRequest;
import adopet.apiadopet.dto.response.MostrarAdocaoResponse;
import adopet.apiadopet.entity.Adocao;
import adopet.apiadopet.repository.AdocaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository repository;

    @Transactional
    public ResponseEntity criar(CriarAdocaoRequest dtoRequest, UriComponentsBuilder uriBuilder) {
        var pet = PetService.retornaPet(dtoRequest.idPet());
        var tutor = TutorService.retornaTutor(dtoRequest.idTutor());
        var adocao = new Adocao(dtoRequest, pet, tutor);
        repository.save(adocao);

        var adocaoResponse = new MostrarAdocaoResponse(adocao);

        var uri = uriBuilder.path("/api/adocao/{id}").buildAndExpand(adocao.getId()).toUri();

        return ResponseEntity.created(uri).body(adocaoResponse);
    }
}
