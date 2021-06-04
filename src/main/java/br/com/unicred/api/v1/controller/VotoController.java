package br.com.unicred.api.v1.controller;

import br.com.unicred.api.v1.adapter.VotoAdapter;
import br.com.unicred.api.v1.controller.errors.ErroVM;
import br.com.unicred.api.v1.dto.VotoCadastrarRequestDto;
import br.com.unicred.api.v1.dto.VotoCadastrarResponseDto;
import br.com.unicred.api.v1.dto.VotoResultadoResponseDto;
import br.com.unicred.config.Constantes;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static br.com.unicred.config.Constantes.*;
import static br.com.unicred.config.Constantes.Urls.PATH_VOTO;
import static br.com.unicred.config.Constantes.Urls.PATH_V_1;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(PATH_V_1)
@RequiredArgsConstructor
public class VotoController {

    private final VotoAdapter adapter;

    @PostMapping(PATH_VOTO)
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_STATUS_CODE_200,
                            message = Constantes.HTTP_STATUS_DESC_OK,
                                response = VotoCadastrarResponseDto.class),
            @ApiResponse(code = HTTP_STATUS_CODE_400,
                            message = HTTP_STATUS_DESC_BAD_REQUEST,
                                response = ErroVM.class)})
    @Transactional
    public ResponseEntity<VotoCadastrarResponseDto> cadastrarVoto(@Valid @RequestBody VotoCadastrarRequestDto request){
        VotoCadastrarResponseDto response = adapter.cadastrar(request);
        return ResponseEntity.status(CREATED)
                .body(response);
    }

    @GetMapping(PATH_VOTO + "/{idPauta}")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_STATUS_CODE_200,
                            message = Constantes.HTTP_STATUS_DESC_OK,
                                response = VotoResultadoResponseDto.class),
            @ApiResponse(code = HTTP_STATUS_CODE_400,
                            message = HTTP_STATUS_DESC_BAD_REQUEST,
                                response = ErroVM.class)})
    @Transactional
    public ResponseEntity<VotoResultadoResponseDto> obterResultado(@Valid @PathVariable Long idPauta){
        VotoResultadoResponseDto response = adapter.obterResultado(idPauta);
        return ResponseEntity.ok(response);
    }
}
