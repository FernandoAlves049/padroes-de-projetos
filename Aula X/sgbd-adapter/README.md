# Professor, leia-me

## Por que utilizar Spring Boot e uma Interface Web?

Decidi implementar esta atividade do **Padrão Adapter** utilizando o Spring Boot e uma interface gráfica Web em vez de uma aplicação tradicional em linha de comando (Console/Terminal).

Fiz essa escolha pelos seguintes motivos:

1. **Facilidade de Visualização**: A interface web (acessível pelo navegador) permite visualizar o Padrão Adapter em funcionamento de maneira muito mais clara e interativa. É possível trocar os "Perfis" clicando neles e ver imediatamente o resultado do Adapter correspondente sendo aplicado.
2. **Execução Simplificada**: Ao rodar a aplicação web, não é necessário compilar e rodar múltiplos comandos ou inspecionar textos longos no console. Basta acessar o navegador e testar os diferentes fluxos (Gratuito, Básico, Ultimate).
3. **Casos de Uso Reais**: Aplicações modernas frequentemente expõem padrões de projeto arquiteturais através de APIs REST. Utilizar o Spring Boot demonstra como o Padrão Adapter se integra perfeitamente a uma arquitetura Web real (Client -> Controller -> Service -> **Adapter** -> Adaptee).

Apesar da camada Web, o cerne do exercício — o Padrão Adapter — está implementado de forma pura e estrita dentro do pacote `br.com.adapter.adapter` e `br.com.adapter.factory`. O Spring Boot funciona apenas como o "Cliente" que consome essas interfaces.

---

## Como executar o projeto

1. Abra o terminal na pasta raiz do projeto (`sgbd-adapter`).
2. Execute o comando:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

3. Abra o navegador e acesse: **<http://localhost:8080>**
