package entidades;

public class FluxoCaixa {
    private double saldoTotal = 0.0;

    // Função para adicionar dinheiro ao caixa
    public void registrarVenda(double valorVenda) {
        this.saldoTotal += valorVenda;
    }

    //Exibe quanto tem no caixa
    public double getSaldoTotal() {
        return saldoTotal;
    }

}
