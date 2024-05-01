package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.CriarAdocaoRequest;
import adopet.apiadopet.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
