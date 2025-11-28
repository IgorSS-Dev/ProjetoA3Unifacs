package entidades;

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Usando o getPreco da classe Produto através da colaboração entre objetos
    public double getSubtotal () {
        return produto.getPreco() * quantidade;
    }
}
