package entidades;

public abstract class Produto {
    // Atributo para gerar o código do produto autoticamente
    private static int proximoCodigo = 1;

    private int codigo;
    private String nome;
    private double preco;
    private String categoria;
    private String fornecedor;
    private int estoque;


    public Produto(String nome, String categoria, double preco, String fornecedor, int estoque) {

        // Contador do código
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.estoque = estoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                "\n | Nome: " + nome +
                "\n | Preço: " + preco +
                "\n | Categoria: " + categoria +
                "\n | Fornecedor: " + fornecedor +
                "\n | Estoque: " + estoque;


    }
}