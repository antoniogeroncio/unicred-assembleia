package br.com.unicred.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constantes {

    public static final int HTTP_STATUS_CODE_200 = 200;
    public static final int HTTP_STATUS_CODE_400 = 400;
    public static final String HTTP_STATUS_DESC_OK = "OK";
    public static final String HTTP_STATUS_DESC_BAD_REQUEST = "Bad Request";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Error {
        public static final String ERR_INTERNAL_SERVER_ERROR = "error.internal_server_error";
        public static final String ERR_VALIDATION = "error.validation";
        public static final String MSG_INTERNAL_SERVER_ERROR = "Erro interno do servidor";
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Urls{
        public static final String PATH_V_1 = "/v1";
        public static final String PATH_PAUTA = "/pauta";
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Mensagens{
        public static final String MSG_O_CAMPO_NOME_E_OBRIGATORIO = "O campo nome é obrigatório";
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class ApiDoc{
        public static final String API_DOC_NOME_DA_PAUTA = "Nome da Pauta";
        public static final String API_DOC_DESCRICAO_DA_PAUTA = "Descrição da Pauta";
    }


}
