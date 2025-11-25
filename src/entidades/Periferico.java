package entidades;

// Classe filha que herda os atributos da classe Produto
public class Periferico extends Produto {
    private String conector;
    private String cor;

    public Periferico(String nome, String categoria, double preco, String fornecedor, int estoque, String conector, String cor) {
        super(nome, categoria, preco, fornecedor, estoque);
        this.conector = conector;
        this.cor = cor;
    }

    public String getConector() {
        return conector;
    }

    public void setConector(String conector) {
        this.conector = conector;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        // Chamando o toString da classe Produto
        String infoProduto = super.toString();
        return infoProduto + "\n | Conector: " + conector +
                "\n | Cor: " + cor;

    }
}

