package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.EfetuarLoginRequest;
import adopet.apiadopet.dto.response.DadosJWTResponse;
import adopet.apiadopet.entity.Usuario;
import adopet.apiadopet.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid EfetuarLoginRequest dtoLogin) {
        var token = new UsernamePasswordAuthenticationToken(dtoLogin.login(), dtoLogin.senha());
        var authentication = manager.authenticate(token);

        var jwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosJWTResponse(jwt));
    }
}
