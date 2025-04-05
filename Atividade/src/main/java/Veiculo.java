public class Veiculo {
    protected String modelo;
    protected double valorDiaria;

    public Veiculo(String modelo, double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("O valor da diária deve ser maior que 0.");
        }
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;

    }

    public double calcularCusto(double valorDiaria, int quantidadeDias, int quantidadeDiasAtraso) {
        try {
            if (quantidadeDias <= 0) {
                throw new IllegalArgumentException("A quantidade de dias deve ser maior que 0.");
            }

            double valorFinal;

            if (quantidadeDias >= 7 && quantidadeDiasAtraso == 0) {
                valorFinal = desconto(valorDiaria, quantidadeDias);
            } else {
                valorFinal = valorDiaria * quantidadeDias;
            }

            return calcularMultas(valorFinal, quantidadeDiasAtraso);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao calcular custo: " + e.getMessage());
            return 0;
        } finally {
            System.out.println("Cálculo de custo finalizado.");
        }
    }

    public double desconto(double valorDiaria, int quantidadeDias) {
        double porcentagemDesconto = 0;

        if (quantidadeDias >= 30) {
            porcentagemDesconto = 0.30;
        } else if (quantidadeDias >= 15) {
            porcentagemDesconto = 0.20;
        } else if (quantidadeDias >= 7) {
            porcentagemDesconto = 0.10;
        }

        return (valorDiaria * quantidadeDias) * (1 - porcentagemDesconto);
    }

    public double calcularMultas(double valor, int quantidadeDiasAtraso) {
        return valor + (valor * (quantidadeDiasAtraso * 0.2));
    }
}
