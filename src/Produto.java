// Classe para cadastrar produtos
public class Produto {
    private static int proximoCodigo = 1;

    private int codigo;
    private String nome;
    private String categoria;
    private String fornecedor;
    private int estoque;

    //


    public Produto(String nome, String categoria, String fornecedor, int estoque) {
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.nome = nome;
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
                " | Nome: " + nome +
                " | Categoria: " + categoria +
                " | Fornecedor: " + fornecedor +
                " | Estoque: " + estoque;


    }
}