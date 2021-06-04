package br.com.unicred.service.impl;

import br.com.unicred.domain.Pauta;
import br.com.unicred.repository.jpa.PautaRepository;
import br.com.unicred.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PautaServiceImpl implements PautaService {

    private final PautaRepository repository;

    @Override
    public Pauta cadastrar(Pauta pauta) {
        return repository.save(pauta);
    }
}
