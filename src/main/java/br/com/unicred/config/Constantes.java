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
        public static final String PATH_SESSAO = "/sessao";
        public static final String PATH_VOTO = "/voto";
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Mensagens{
        public static final String MSG_O_CAMPO_CPF_ASSOC_E_OBRIGATORIO = "O campo cpf do associado é obrigatório";
        public static final String MSG_O_CAMPO_VOTO_ASSOC_E_OBRIGATORIO = "O campo voto do associado é obrigatório";
        public static final String MSG_O_CAMPO_NOME_E_OBRIGATORIO = "O campo nome é obrigatório";
        public static final String MSG_O_CAMPO_ID_PAUTA_E_OBRIGATORIO = "O campo id da pauta é obrigatório";
        public static final String MSG_A_PAUTA_JA_POSSUI_SESSAO = "A pauta já possui sessão";
        public static final String MSG_A_PAUTA_NAO_EXISTE = "A pauta informada não existe";
        public static final String MSG_A_SESSAO_PAUTA_N_ABERTA_NAO_EXISTE = "A sessão da pauta não foi aberta";
        public static final String MSG_O_ASSOCIADO_NAO_EXISTE = "O associado informado não existe";
        public static final String MSG_O_ASSOCIADO_CPF_INVALIDO = "O associado possui cpf invalido, favor regularizar";
        public static final String MSG_O_ASSOCIADO_NAO_ELEGIVEL = "O associado informado não está elegivel, " +
                "favor regularizar situação junto a diretoria";
        public static final String MSG_A_SESSAO_JA_FOI_FINALIZADA = "A sessão já foi finalizada";
        public static final String MSG_O_ASSOCIADO_JA_VOTO_PAUTA = "O associado já votou na pauta";
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class ApiDoc{
        public static final String API_DOC_NOME_DA_PAUTA = "Nome da Pauta";
        public static final String API_DOC_DESCRICAO_DA_PAUTA = "Descrição da Pauta";
        public static final String API_DOC_ID_DA_PAUTA = "Id da Pauta";
        public static final String API_DOC_CPF_ASSOC_DA_PAUTA = "CPF do Associado";
        public static final String API_DOC_VOTO_ASSOC_DA_PAUTA = "Voto do Associado";
        public static final String API_DOC_TEMPO_DA_SESSAO = "Tempo da Sessão";
        public static final String API_DOC_BASE_CONTROLLER = "br.com.unicred.api.v1.controller";
        public static final String API_DOC_TITULO_UNICRED_ASSEMBLEIA = "Unicred Assembleia";
        public static final String API_DOC_DESCRICAO_PARA_ASSEMBLEIAS_DA_UNICRED = "API para Assembleias da Unicred";
        public static final String API_DOC_VERSAO = "1.0.0";
        public static final String API_DOC_TERMOS_DE_USO = "Termos de uso";
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Querys{
        public static final String QUERY_OBTER_RESULTADO_POR_ID_PAUTA =
                "SELECT new br.com.unicred.domain.vo.VotacaoResultado(p.nome, " +
                        "(SELECT COUNT(s) FROM Voto s WHERE s.voto = true AND s.id.idPauta = p.id), " +
                        "(SELECT COUNT(f) FROM Voto f WHERE f.voto = false AND f.id.idPauta = p.id)) " +
                "FROM Pauta p WHERE p.id = :idPauta";

    }




}
