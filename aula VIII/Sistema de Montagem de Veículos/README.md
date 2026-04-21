# Sistema de Montagem de Veículos

Projeto em Java que demonstra o uso do padrão Builder clássico da GoF para montar veículos com etapas fixas de construção.

## Objetivo

A fábrica produz três tipos de veículos:

1. Carro
2. Caminhão
3. Moto

Todos seguem a mesma sequência de montagem:

1. Motor
2. Transmissão
3. Pintura
4. Rodas

O que muda entre eles são os detalhes de cada etapa.

## Padrão Utilizado

Este projeto aplica o Builder clássico com os seguintes papéis:

- `Veiculo`: produto final montado.
- `VeiculoBuilder`: interface que define as etapas de construção.
- `VeiculoBuilderBase`: classe abstrata com comportamento compartilhado.
- `CarroBuilder`, `CaminhaoBuilder`, `MotoBuilder`: builders concretos.
- `DiretorMontagem`: controla a ordem fixa da montagem.
- `App`: ponto de entrada da aplicação.

## Estrutura do Projeto

```text
src/
├── App.java
├── CarroBuilder.java
├── CaminhaoBuilder.java
├── DiretorMontagem.java
├── MotoBuilder.java
├── Veiculo.java
├── VeiculoBuilder.java
└── VeiculoBuilderBase.java
```

## Como Executar

### Compilar

```bash
javac -d bin src/*.java
```

### Executar

```bash
java -cp bin App
```

## Saída Esperada

Ao executar o projeto, a saída exibida no console é organizada por tipo de veículo, por exemplo:

```text
=== Montagem de Veiculos ===

Carro:
Veiculo {
	tipo: Carro
	motor: Motor 1.6 Flex
	transmissao: Transmissao automatica de 6 marchas
	cor: Prata metalico
	rodas: 4 rodas aro 16
}
```

Os dados de caminhão e moto seguem o mesmo formato.

## Observações

- O projeto não usa pacotes, para manter a estrutura simples e didática.
- A lógica de montagem está centralizada no `DiretorMontagem`, deixando o processo fácil de manter e expandir.
- Para adicionar um novo veículo, basta criar um novo builder concreto seguindo a mesma interface.
