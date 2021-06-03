package br.com.unicred.api.v1.controller.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErroVM implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String id;
    private final String mensagem;
    private List<CampoErrorVM> camposErrors;

    public ErroVM(String id) {
        this(null, id);
    }

    public ErroVM(String mensagem, String id) {
        this.mensagem = mensagem;
        this.id = id;
    }

    public void add(String objetoNome, String campo, String mensagem) {
        if (camposErrors == null) {
            camposErrors = new ArrayList<>();
        }
        camposErrors.add(new CampoErrorVM(objetoNome, campo, mensagem));
    }
}
