package br.com.unicred.api.v1.controller;

import br.com.unicred.api.v1.adapter.PautaAdapter;
import br.com.unicred.api.v1.adapter.SessaoAdapter;
import br.com.unicred.api.v1.controller.errors.ErroVM;
import br.com.unicred.api.v1.dto.PautaCadastrarRequestDto;
import br.com.unicred.api.v1.dto.PautaCadastrarResponseDto;
import br.com.unicred.api.v1.dto.SessaoAbrirRequestDto;
import br.com.unicred.api.v1.dto.SessaoAbrirResponseDto;
import br.com.unicred.config.Constantes;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static br.com.unicred.config.Constantes.*;
import static br.com.unicred.config.Constantes.Urls.*;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(PATH_V_1)
@RequiredArgsConstructor
public class SessaoController {

    private final SessaoAdapter adapter;

    @PostMapping(PATH_SESSAO)
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_STATUS_CODE_200,
                            message = Constantes.HTTP_STATUS_DESC_OK,
                                response = SessaoAbrirResponseDto.class),
            @ApiResponse(code = HTTP_STATUS_CODE_400,
                            message = HTTP_STATUS_DESC_BAD_REQUEST,
                                response = ErroVM.class)})
    @Transactional
    public ResponseEntity<SessaoAbrirResponseDto> abrirSessao(@Valid @RequestBody SessaoAbrirRequestDto request){
        SessaoAbrirResponseDto response = adapter.abrir(request);
        return ResponseEntity.ok(response);
    }
}
