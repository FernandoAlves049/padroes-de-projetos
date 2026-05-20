# Loja de Quadrinhos - Caixa de Assinatura

Aplicação Java em console para gerar caixas de assinatura com itens aleatórios de acordo com o nível do cliente.

## Níveis de assinatura

- Bronze: 3 itens
- Prata: 5 itens
- Ouro: 7 itens
- Platina: 10 itens

## Itens disponíveis

- Quadrinho - R$ 15,00
- Chaveiro - R$ 5,00
- Busto - R$ 10,00
- Adesivo - R$ 1,00
- Poster - R$ 25,00
- Camiseta - R$ 25,00
- Caneta - R$ 3,00
- Miniatura - R$ 20,00

## Como executar

Compile os arquivos Java e execute a classe principal `App`.

Exemplo:

```bash
javac -d bin src/*.java
java -cp bin App
```

## Funcionalidades

- Menu de console
- Geração aleatória dos itens da caixa
- Repetição de itens permitida
- Cálculo automático do valor total
- Exibição organizada da caixa por nível

## Estrutura principal

- `App.java` - ponto de entrada da aplicação
- `CaixaAssinatura.java` - gera e exibe a caixa
- `Item.java` - representa um item da caixa
- `NivelCliente.java` - define os níveis e a quantidade de itens
