import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Coletando dados do usuário
            System.out.print("Digite o modelo do veículo: ");
            String modelo = scanner.nextLine();

            System.out.print("O veículo foi entregue com atraso? (s/n): ");
            String respostaAtraso = scanner.nextLine().trim().toLowerCase();
            int quantidadeDiasAtraso = 0;

            if (respostaAtraso.equals("s")) {
                System.out.print("Digite a quantidade de dias de atraso: ");
                quantidadeDiasAtraso = scanner.nextInt();
            }

            System.out.print("Digite o valor da diária: ");
            double valorDiaria = scanner.nextDouble();

            System.out.print("Digite a quantidade de dias alugados: ");
            int quantidadeDias = scanner.nextInt();

            // Criando o veículo e calculando o custo
            Veiculo veiculo = new Veiculo(modelo, valorDiaria);
            double valorSemDesconto = valorDiaria * quantidadeDias;

            double valorComDesconto;
            double desconto = 0;

            // Aplica desconto apenas se não houve atraso e alugado por 7 ou mais dias
            if (quantidadeDiasAtraso == 0 && quantidadeDias >= 7) {
                valorComDesconto = veiculo.desconto(valorDiaria, quantidadeDias);
                desconto = valorSemDesconto - valorComDesconto;
            } else {
                valorComDesconto = valorSemDesconto;
            }

            double custoTotal = veiculo.calcularCusto(valorDiaria, quantidadeDias, quantidadeDiasAtraso);

            // Exibindo os resultados
            System.out.printf("Custo total do aluguel do veículo %s: R$ %.2f\n", modelo, custoTotal);
            if (quantidadeDiasAtraso == 0 && quantidadeDias >= 7) {
                System.out.printf("Valor de desconto aplicado: R$ %.2f\n", desconto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao processar os dados: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}
