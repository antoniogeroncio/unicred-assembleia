package br.com.unicred.api.v1.controller;

import br.com.unicred.api.v1.controller.errors.ErroVM;
import br.com.unicred.api.v1.dto.PautaCadastrarRequestDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static br.com.unicred.config.Constantes.Error.ERR_VALIDATION;
import static br.com.unicred.config.Constantes.Mensagens.MSG_O_CAMPO_NOME_E_OBRIGATORIO;
import static br.com.unicred.config.Constantes.Urls.PATH_PAUTA;
import static br.com.unicred.config.Constantes.Urls.PATH_V_1;
import static br.com.unicred.config.ConstantesTest.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.Long.parseLong;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

class PautaControllerTest extends AbstractControllerTest {

    @BeforeEach
    public void setUp() {
        cenarioTestHelper.limparBanco();
    }

    @Test
    public void quandoCadastrarPautaSemInformarNomeEntaoDeveraRetornarExcecao(){
        Response response = given()
                    .contentType(JSON)
                .and()
                    .body(PautaCadastrarRequestDto.builder().build())
                .when()
                    .post(PATH_V_1 + PATH_PAUTA)
                .then()
                    .extract().response();

        ErroVM erroResponse = response.body().as(ErroVM.class);
        assertEquals(BAD_REQUEST.value(), response.statusCode());
        assertEquals(ERR_VALIDATION, erroResponse.getId());
        assertEquals(UM_ITEM, erroResponse.getCamposErrors().size());
        assertEquals(MSG_O_CAMPO_NOME_E_OBRIGATORIO, erroResponse.getCamposErrors()
                .stream().findAny().get().getMensagem());
    }

    @Test
    public void quandoCadastrarPautaComDadosValidosEntaoDeveraRetornarIdPauta(){
        Response response = given()
                    .contentType(JSON)
                .and()
                    .body(PautaCadastrarRequestDto.builder()
                            .nome(NOME_PAUTA_EXEMPLO_1)
                            .descricao(DESCRICAO_PAUTA_EXEMPLO_1)
                            .build())
                .when()
                    .post(PATH_V_1 + PATH_PAUTA)
                .then()
                    .extract().response();

        Long idPauta = response.jsonPath().getLong(JSON_PATH_ID);
        Map<String, Object> pauta = cenarioTestHelper.consultarPautaPorId(idPauta);

        assertEquals(CREATED.value(), response.statusCode());
        assertEquals(ID_PAUTA_1L, idPauta);
        assertEquals(ID_PAUTA_1L, parseLong(pauta.get(JSON_PATH_ID).toString()));
        assertEquals(NOME_PAUTA_EXEMPLO_1, pauta.get(JSON_PATH_NOME));
        assertEquals(DESCRICAO_PAUTA_EXEMPLO_1, pauta.get(JSON_PATH_DESCRICAO));
    }

}