package br.com.unicred.repository.client;

import br.com.unicred.repository.client.dto.AssociadoConsultarElegibilidadeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "associadoClient", url = "${client.associado.url}")
public interface AssociadoClient {
    @GetMapping("/users/{cpf}")
    AssociadoConsultarElegibilidadeResponseDto consultarElegibilidade(@PathVariable("cpf") String cpf);
}
