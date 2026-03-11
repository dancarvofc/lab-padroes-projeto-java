# Explorando Padrões de Projetos na Prática com Java

Repositório com as implementações dos padrões de projeto explorados no Lab "Explorando Padrões de Projetos na Prática com Java". Especificamente, este projeto explorou alguns padrões usando Java puro:
- Singleton
- Strategy
- Facade
- Chain of Responsibility

## Evolução aplicada neste desafio

Além dos exemplos base do laboratório, foi adicionado um fluxo de aprovação de pedidos usando `Chain of Responsibility`, com regras de validação encadeadas:

- Validação de cliente ativo;
- Validação de limite de valor para aprovação automática;
- Validação de suspeita de fraude;
- Aprovação final do pedido.

As classes do Chain estão em:

- `src/one/digitalinnovation/gof/chain`

## Como executar

Compilar:

```bash
javac -encoding ISO-8859-1 -d bin $(find src -name '*.java')
```

Executar:

```bash
java -cp bin one.digitalinnovation.gof.Test
```
