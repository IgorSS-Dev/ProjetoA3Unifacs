package entidades;

// Classe filha que herda os atributos da classe Produto
public class Hardware extends Produto {
    private String modelo;
    private int garantiaMeses;
    private int potenciaWatts;
    private String especificaoChave;
    // Coisas como socket, 32GB de ram, interface etc...


    public Hardware(String nome, String categoria, double preco, String fornecedor, int estoque, String modelo, int garantiaMeses, int potenciaWatts, String especificaoChave) {
        super(nome, categoria, preco, fornecedor, estoque);
        this.modelo = modelo;
        this.garantiaMeses = garantiaMeses;
        this.potenciaWatts = potenciaWatts;
        this.especificaoChave = especificaoChave;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public int getPotenciaWatts() {
        return potenciaWatts;
    }

    public void setPotenciaWatts(int potenciaWatts) {
        this.potenciaWatts = potenciaWatts;
    }

    public String getEspecificaoChave() {
        return especificaoChave;
    }

    public void setEspecificaoChave(String especificaoChave) {
        this.especificaoChave = especificaoChave;
    }

    @Override
    public String toString() {
        // Chamando o toString da classe Produto
        String infoProduto = super.toString();
        return infoProduto + "\n | Modelo: " + modelo +
                "\n | Garantia: " + garantiaMeses + " meses" +
                "\n | Potência: " + potenciaWatts + "W" +
                "\n | Espec.: " + especificaoChave;
    }
}