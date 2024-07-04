package adopet.apiadopet.controller;

import adopet.apiadopet.dto.request.CriarTutorRequest;
import adopet.apiadopet.dto.response.MostrarTutorResponse;
import adopet.apiadopet.service.TutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class TutorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CriarTutorRequest> criarTutorRequestJson;

    @Autowired
    private JacksonTester<MostrarTutorResponse> mostrarTutorResponseJson;

    @MockBean
    private TutorService tutorService;

    @Test
    @DisplayName("Devolver código http 400 quando informações estão inválidas")
    @WithMockUser
    void criarCenario1() throws Exception {
        var response = mvc.perform(post("/api/tutor"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(400);
    }

    @Test
    @DisplayName("Devolver código http 200 quando informações estão válidas")
    @WithMockUser
    void criarCenario2() throws Exception {

        //var dtoResponse = new MostrarTutorResponse(null, "tutor1", "ROLE_TUTOR");


        //when(tutorService.criar(any(), any())).thenReturn(dtoResponse);

        var response = mvc
                .perform(
                        post("/api/tutor")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(criarTutorRequestJson.write(
                                        new CriarTutorRequest("tutor1", "tutor@gmail.com", "1234")
                                ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(200);

        var dtoResponse = mostrarTutorResponseJson.write(
                new MostrarTutorResponse(null, "tutor1", "ROLE_TUTOR")
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(dtoResponse);
    }

}