package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.PautaCadastrarRequestDto;
import br.com.unicred.api.v1.dto.PautaCadastrarResponseDto;
import br.com.unicred.domain.Pauta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.unicred.config.ConstantesTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PautaConverterTest {

    @Mock
    PautaCadastrarRequestDto ahConverter;

    @Test
    public void aoConveterEmObjetoInformandoDadosNulosDeveriaRetornarObjetoComDadosNulos(){
        when(ahConverter.getNome()).thenReturn(null);
        when(ahConverter.getDescricao()).thenReturn(null);
        Pauta convertido = PautaConverter.converter(ahConverter);
        assertNull(convertido.getNome());
        assertNull(convertido.getDescricao());
    }

    @Test
    public void aoConveterEmObjetoInformandoDadosDeveriaRetornarObjetoComDados(){
        when(ahConverter.getNome()).thenReturn(NOME_PAUTA_EXEMPLO_1);
        when(ahConverter.getDescricao()).thenReturn(DESCRICAO_PAUTA_EXEMPLO_1);
        Pauta convertido = PautaConverter.converter(ahConverter);
        assertEquals(NOME_PAUTA_EXEMPLO_1, convertido.getNome());
        assertEquals(DESCRICAO_PAUTA_EXEMPLO_1, convertido.getDescricao());
    }
}