package br.com.unicred.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
public class DocumentacaoConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(basePackage("br.com.unicred.api.v1.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Unicred Assembleia",
                "API para Assembleias da Unicred",
                "0.0.1-SNAPSHOT",
                "Termos de uso",
                ApiInfo.DEFAULT_CONTACT,
                null, null, Collections.emptyList());
    }
}
