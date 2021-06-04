package br.com.unicred.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static br.com.unicred.config.Constantes.ApiDoc.*;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
public class DocumentacaoConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(basePackage(API_DOC_BASE_CONTROLLER))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                API_DOC_TITULO_UNICRED_ASSEMBLEIA,
                API_DOC_DESCRICAO_PARA_ASSEMBLEIAS_DA_UNICRED,
                API_DOC_VERSAO,
                API_DOC_TERMOS_DE_USO,
                ApiInfo.DEFAULT_CONTACT,
                null, null, Collections.emptyList());
    }
}
