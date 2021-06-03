package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.PautaCadastrarResponseDto;
import br.com.unicred.domain.Pauta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.unicred.config.ConstantesTest.ID_PAUTA_1L;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PautaCadastrarResponseDtoConverterTest {

    @Mock
    Pauta ahConverter;

    @Test
    public void aoConveterEmObjetoInformandoDadosNulosDeveriaRetornarObjetoComDadosNulos(){
        when(ahConverter.getId()).thenReturn(null);
        PautaCadastrarResponseDto convertido = PautaCadastrarResponseDtoConverter.converter(ahConverter);
        assertNull(convertido.getId());
    }

    @Test
    public void aoConveterEmObjetoInformandoDadosDeveriaRetornarObjetoComDados(){
        when(ahConverter.getId()).thenReturn(ID_PAUTA_1L);
        PautaCadastrarResponseDto convertido = PautaCadastrarResponseDtoConverter.converter(ahConverter);
        assertEquals(ID_PAUTA_1L, convertido.getId());
    }
}