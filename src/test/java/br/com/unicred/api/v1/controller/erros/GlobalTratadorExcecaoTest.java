package br.com.unicred.api.v1.controller.erros;

import br.com.unicred.api.v1.adapter.PautaAdapter;
import br.com.unicred.api.v1.controller.PautaController;
import br.com.unicred.api.v1.controller.errors.GlobalTratadorExcecao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static br.com.unicred.config.Constantes.Urls.PATH_PAUTA;
import static br.com.unicred.config.Constantes.Urls.PATH_V_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GlobalTratadorExcecaoTest{

    @Autowired
    private GlobalTratadorExcecao globalTratadorExcecao;

    @MockBean
    private PautaAdapter adapterMock;

    private ResultActions actions;

    private PautaController pautaController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        pautaController = new PautaController(adapterMock);
        mockMvc = MockMvcBuilders.standaloneSetup(pautaController)
                .setControllerAdvice(globalTratadorExcecao)
                .build();
    }

    @Test
    public void quandoLancarExcecaoNaoTratadaDeveriaRetornarExcecaoErroInterno() throws Exception {
        actions = mockMvc.perform(MockMvcRequestBuilders.post(PATH_V_1 + PATH_PAUTA));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), actions.andReturn().getResponse().getStatus());
    }
}
