# Unicred Assembleia - Serviço Web de Assembleias da Unicred do Brasil

[![CircleCI](https://circleci.com/gh/antoniogeroncio/unicred-assembleia.svg?style=svg&circle-token=5789e4a68ef5a3d7253380bfe8ed4402fd05d245)](https://circleci.com/gh/antoniogeroncio/unicred-assembleia)
https://app.circleci.com/pipelines/github/antoniogeroncio/unicred-assembleia

[![Codecov](https://codecov.io/gh/antoniogeroncio/unicred-assembleia/branch/master/graph/badge.svg?token=JtxkbLANwg)](https://codecov.io/gh/antoniogeroncio/unicred-assembleia)
https://app.codecov.io/gh/antoniogeroncio/unicred-assembleia

# Tecnologias usadas

Github(Controle de versão Git)
Docker,
Java,
Spring Boot,
PostgreSQL(Banco de dados),
Feign(Integração de API) 
Junit(Unit testing framework)

# Metodologia de Desenvolvimento

TDD: Test-Driven Development (TDD) - Por amostra na estória cadastra pauta

Para eliminar e / ou mitigar bugs foi adicionada ao processo de desenvolvimento a integração contínua.

De acordo com Martin Fowler: “A integração contínua não elimina os bugs, mas os torna muito mais fáceis de localizar e remover.”

Integração contínua (CI) é uma prática de desenvolvimento que requer que os desenvolvedores integrem o código em um repositório compartilhado várias vezes ao dia. Cada check-in é então verificado por uma compilação automatizada, permitindo que as equipes detectem problemas antecipadamente.

Ref: https://www.thoughtworks.com/continuous-integration

Assim, a ferramenta CircleCI foi selecionada como ferramenta CI.

A ferramenta CODECOV foi adicionada para fornecer visualmente qual código-fonte está sendo executado por um conjunto de testes. 
Essas informações informam ao desenvolvedor de software onde escrever novos testes em um esforço para obter maior cobertura.
Testar o código-fonte ajuda a evitar bugs e erros de sintaxe, executando cada linha com uma variável conhecida e verificando-a com uma saída esperada.

Ref: https://docs.codecov.io/docs/about-code-coverage

# Distribuição

Este projeto é distribuído como uma imagem docker e está hospedado no Docker Hub.

Link: https://hub.docker.com/repository/docker/antoniogeroncio/unicred-assembleia

# Implantação

Link: https://github.com/antoniogeroncio/unicred-assembleia

Abrir terminal

1 - `git clone https://github.com/antoniogeroncio/unicred-assembleia.git`

2 - `cd unicred-assembleia/devops/docker-compose/`

3 - `docker-compose up -d`

Obs.: Docker e Docker-Compose são requisitos para rodar os comandos acima.

Abrir Navegador

http://localhost:8081/swagger-ui/index.html
 
 


