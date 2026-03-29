# Singleton com MultiThreads

Aplicacao Java para simular acesso concorrente a um banco de dados usando o padrao Singleton.

## Objetivo

Garantir que apenas uma instancia de `DatabaseConnectionManager` seja criada e compartilhada por varias threads, evitando problemas de concorrencia na manipulacao da conexao.

## Requisitos atendidos

- Classe `DatabaseConnectionManager` implementada como Singleton thread-safe.
- Classe `DatabaseAccessThread` para representar threads de acesso ao banco.
- Criacao de pelo menos 5 threads simultaneas.
- Compartilhamento da mesma instancia do gerenciador entre todas as threads.

## Estrutura do projeto

- `src/App.java`: ponto de entrada da aplicacao e criacao das threads.
- `src/DatabaseConnectionManager.java`: Singleton do gerenciador de conexao.
- `src/DatabaseAccessThread.java`: thread que solicita acesso ao banco.
- `bin/`: arquivos compilados.

## Como compilar e executar (PowerShell)

```powershell
Set-Location "d:\if 5º periodo\PP\aula V.3"
javac -d bin src\*.java
java -cp bin App
```

## Exemplo de saida esperada

```text
Gerenciador de conexao criado uma unica vez.
Thread-DB-1 usando conexao 123456789
Thread-DB-1 finalizou operacao no banco.
...
Todas as threads finalizaram.
```

Observacao: o numero da conexao (hash) deve ser o mesmo para todas as threads, indicando que a mesma instancia Singleton foi compartilhada.
