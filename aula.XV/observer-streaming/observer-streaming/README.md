# Streaming Observer — Instruções de Uso (para o professor)

Este README explica como executar e avaliar a aplicação `observer-streaming`, visualizar o diagrama UML adicionado e como testar o fluxo do padrão Observer (plataforma → clientes).

Pré-requisitos

- Java 17+ (recomendado: Java 21)
- Maven (ou use o `mvnw` presente no projeto)

Como executar localmente

1. Pelo terminal (usa o Maven Wrapper):

```powershell
cd observer-streaming
.\mvnw spring-boot:run
```

Por padrão a aplicação tenta iniciar na porta `8080`. Se a porta já estiver em uso, execute com outra porta:

```powershell
.\mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dserver.port=8081"
```

Ou crie o JAR e execute diretamente:

```powershell
.\mvnw package -DskipTests
java -jar target\observer-streaming-0.0.1-SNAPSHOT.jar --server.port=8081
```

Páginas principais

- `/` — Dashboard principal: cadastro de usuários, formulário de publicação e log de notificações.
- `/uml` — Página com os diagramas UML (arquivo `observer-uml.svg` e `StreamingPlatform-2026-06-09-223708.svg`).
- `/observer` — Explicação passo a passo do padrão Observer.
- `/sobre` — Informações do projeto.

Onde está o diagrama que adicionei

- Arquivo SVG: `src/main/resources/static/images/StreamingPlatform-2026-06-09-223708.svg`.
- A página `/uml` já foi atualizada para exibir esse SVG abaixo do diagrama `observer-uml.svg`.

Testando o fluxo Observer (exemplo rápido)

1. Abra o dashboard (`http://localhost:8080/` ou porta definida).
2. Na seção de usuários, adicione alguns usuários (ex.: João, Maria, Pedro) — o seed já cria alguns por padrão.
3. Use o formulário de publicação para criar um novo `MediaRelease` (título, gênero, tipo).
4. Após publicar, verifique o painel de notificações — cada `Client` inscrito no gênero selecionado receberá uma notificação.

Execução de testes

```powershell
.\mvnw test
```

Arquivos relevantes

- `src/main/java/.../observer` — classes do padrão Observer (`StreamingPlatform`, `Client`, etc.).
- `src/main/java/.../web/StreamingCatalogService.java` — serviço em memória que gerencia clients e releases.
- `src/main/resources/templates/index.html` — interface principal (Thymeleaf + Bootstrap).
- `src/main/resources/static/images/StreamingPlatform-2026-06-09-223708.svg` — diagrama adicionado.

Como avaliar

- Verifique se a UI responde corretamente: criar usuário, publicar conteúdo, verificar notificações.
- Observe os logs do console: ao iniciar a aplicação o seed de exemplo registra notificações para confirmar o comportamento.

Observações adicionais

- Caso queira substituir o SVG por outro gerado externamente, coloque o arquivo em `src/main/resources/static/images/` e atualize o `uml.html` se necessário.
- Para regenerar um diagrama a partir do código Mermaid (não automatizado aqui), use um editor Mermaid offline ou online e exporte SVG.

Guia rápido (passo-a-passo) para o professor

1) Preparar e iniciar a aplicação

- Abra um terminal na pasta do projeto (`observer-streaming`).
- Se preferir rodar direto via Maven Wrapper:

```powershell
.\mvnw spring-boot:run
```

- Se a porta `8080` estiver ocupada, inicie em outra porta (ex.: 8081):

```powershell
.\mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

- Alternativa: empacote e execute o JAR:

```powershell
.\mvnw package -DskipTests
java -jar target\observer-streaming-0.0.1-SNAPSHOT.jar --server.port=8081
```

1) Abrir a aplicação no navegador

- Acesse `http://localhost:8080/` (ou `http://localhost:8081/` se mudar a porta).

1) Fluxo de avaliação — passos para demonstrar o padrão Observer

- Verificar usuários seed: na lateral/aba de usuários você verá clientes já criados (João, Maria, Pedro, etc.).
- Criar novos usuários (opcional): use o formulário "Adicionar usuário" para criar nomes de teste.
- Publicar conteúdo: no formulário de publicação insira `Título`, `Gênero` (ex.: Ação, Terror, Anime), `Tipo` (Filme/Série) e clique em publicar.
- Conferir notificações: após publicar, observe a lista de notificações no dashboard — cada usuário inscrito no gênero do conteúdo deve receber uma notificação.
- Conferir console: no terminal onde a aplicação está rodando, serão impressas linhas do tipo "[HH:MM] Nome recebeu notificação: Novo filme de ..." — isso comprova que os observers foram notificados.

1) Demonstração com 5 clientes

- Se desejar provar carga funcional mínima, crie ou confirme 5 usuários diferentes.
- Publique 2–3 `MediaRelease` com gêneros diferentes; verifique que apenas os usuários interessados recebem notificações correspondentes.

1) Ver o diagrama UML

- Abra `http://localhost:8080/uml` para ver os SVGs: `observer-uml.svg` e `StreamingPlatform-2026-06-09-223708.svg`.

1) Critérios de avaliação sugeridos

- A aplicação inicia sem erros e a página principal carrega.
- Cadastros de usuário funcionam e aparecem na lista.
- Publicações geram notificações visíveis no painel e no console.
- A página `/uml` mostra os diagramas (SVGs) adicionados.

1) Problemas comuns & soluções rápidas

- Porta 8080 ocupada: identificar PID com `netstat -ano | findstr :8080` e finalizar com `taskkill /PID <PID> /F`, ou rodar em outra porta conforme indicado acima.
- Erro ao empacotar (repackage): apague manualmente `target\observer-streaming-0.0.1-SNAPSHOT.jar` se existir e reexecute `mvnw package`.

Se quiser, eu publico um PDF com este guia formatado para entrega ao professor.
