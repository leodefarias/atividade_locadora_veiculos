import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    @Test
    public void testCalculoSemDescontoSemMulta() {
        Veiculo veiculo = new Veiculo("Gol", 100);
        double resultado = veiculo.calcularCusto(100, 6, 0); // sem desconto, sem multa
        assertEquals(600.0, resultado);
    }

    @Test
    public void testCalculoComDescontoSemMulta() {
        Veiculo veiculo = new Veiculo("Fiorino", 80);
        // 8 dias → 10% de desconto → 80*8 = 640 - 64 = 576
        double resultado = veiculo.calcularCusto(80, 8, 0);
        assertEquals(576.0, resultado, 0.01);
    }

    @Test
    public void testCalculoComMultaSemDesconto() {
        Veiculo veiculo = new Veiculo("Camaro", 200);
        // 5 dias → sem desconto → 200*5 = 1000
        // 3 dias de atraso → multa = 1000 * (0.2 * 3) = 600 → total = 1600
        double resultado = veiculo.calcularCusto(200, 5, 3);
        assertEquals(1600.0, resultado, 0.01);
    }

    @Test
    public void testCalculoComDescontoEComMultaNaoAplicaDesconto() {
        Veiculo veiculo = new Veiculo("Uno", 100);
        // 10 dias → teria 10% de desconto, mas como tem atraso, não aplica
        // valor = 1000 → 2 dias de atraso → multa = 1000 * 0.4 = 400 → total = 1400
        double resultado = veiculo.calcularCusto(100, 10, 2);
        assertEquals(1400.0, resultado, 0.01);
    }

    @Test
    public void testDesconto30Porcento() {
        Veiculo veiculo = new Veiculo("Saveiro", 100);
        double valorComDesconto = veiculo.desconto(100, 30); // 30% de desconto
        assertEquals(2100.0, valorComDesconto, 0.01);
    }

    @Test
    public void testDesconto20Porcento() {
        Veiculo veiculo = new Veiculo("Palio", 50);
        double valorComDesconto = veiculo.desconto(50, 20); // 20% de desconto
        assertEquals(800.0, valorComDesconto, 0.01);
    }

    @Test
    public void testCalculoMultas() {
        Veiculo veiculo = new Veiculo("Celta", 100);
        double valorComMulta = veiculo.calcularMultas(500, 2); // multa = 500 * 0.4 = 200 → total = 700
        assertEquals(700.0, valorComMulta, 0.01);
    }

    @Test
    public void testValorDiariaInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Veiculo("Inválido", 0);
        });
        assertEquals("O valor da diária deve ser maior que 0.", exception.getMessage());
    }

    @Test
    public void testQuantidadeDiasInvalida() {
        Veiculo veiculo = new Veiculo("Corolla", 120);
        double resultado = veiculo.calcularCusto(120, 0, 0);
        assertEquals(0.0, resultado);
    }

}
