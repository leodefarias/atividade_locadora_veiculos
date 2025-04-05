# 📦 Projeto: Sistema de Cálculo de Aluguel de Veículos

Este projeto Java implementa um sistema para calcular o custo do aluguel de veículos, considerando descontos por longos períodos de aluguel e multas por atraso na devolução.

---

## 👤 Informações do Aluno

- **Nome:** Leonardo de Farias  
- **RM:** 555211  
- **Turma:** 2ESPX  

---

## 📁 Estrutura do Projeto

- `Main.java`: Classe principal que interage com o usuário via terminal.
- `Veiculo.java`: Classe que representa um veículo e contém a lógica de cálculo de custo, descontos e multas.
- `VeiculoTest.java`: Classe de testes unitários com JUnit para verificar todos os métodos e cenários da classe `Veiculo`.

---

## 🧠 Funcionalidades

- Cálculo do custo total de aluguel com base na diária e dias alugados.
- Aplicação de **desconto** automático conforme a duração:
  - 7 a 14 dias: 10%
  - 15 a 29 dias: 20%
  - 30 dias ou mais: 30%
- Aplicação de **multa por atraso**: 20% por dia de atraso.
- **Descontos não são aplicados se houver atraso**.
- Validações:
  - Valor da diária deve ser maior que zero.
  - Quantidade de dias alugados deve ser maior que zero.

---

## 🧪 Testes

O arquivo `VeiculoTest.java` contém testes para:
- Casos com e sem desconto.
- Casos com e sem multa.
- Verificação de não aplicação de desconto quando há atraso.
- Testes para exceções em valores inválidos.

Os testes utilizam **JUnit 5** (`org.junit.jupiter.api`).

---

## ▶️ Como Executar

1. Compile os arquivos:

```bash
javac Main.java Veiculo.java
