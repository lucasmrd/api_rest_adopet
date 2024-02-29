package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.CriarAbrigoRequest;
import adopet.apiadopet.repository.AbrigoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/abrigo")
public class AbrigoController {

    private AbrigoRepository abrigoRepository;

    public ResponseEntity criar(@RequestBody @Valid CriarAbrigoRequest dtoRequest) {
        
        return ResponseEntity.ok().build();
    }
}
