package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.CriarTutorRequest;
import adopet.apiadopet.entity.Tutor;
import adopet.apiadopet.repository.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid CriarTutorRequest criarTutorRequest) {
        var tutor = new Tutor(criarTutorRequest);
        tutorRepository.save(tutor);

        System.out.println();

        return ResponseEntity.ok().build();
    }
}
