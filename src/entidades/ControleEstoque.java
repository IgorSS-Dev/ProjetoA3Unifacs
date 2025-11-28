package entidades;

import java.util.ArrayList;
import java.util.List;


public class ControleEstoque {
    // Uso do arraylist para simular um "banco de dados"
    private static List<Produto> listaDeProdutos = new ArrayList<>();

    // Bloco de inicialização de código (Acontece automaticamente, sem chamar o construtor)
    // É estático pois usa apenas uma vez
    static {
        // Exemplo de lista de Hardware
        listaDeProdutos.add(new Hardware("Processador Core i5-13600K", "Hardware", 1899.90, "Intel", 20, "BX8071513600K", 12, 125, "LGA 1700"));
        listaDeProdutos.add(new Hardware("Placa de Vídeo RTX 4060 OC", "Hardware", 2399.90, "Gigabyte", 15, "GV-N4060OC", 24, 115, "8GB GDDR6"));
        listaDeProdutos.add(new Hardware("SSD 1TB 980 Pro", "Hardware", 699.90, "Samsung", 30, "MZ-V8P1T0B", 8, 60, "Leitura 7000MB/s"));
        listaDeProdutos.add(new Hardware("Placa Mãe Asus TUF Gaming B550M", "Hardware", 949.90, "Asus", 12, "TUF-B550M-PLUS", 12, 50, "Socket AM4"));
        listaDeProdutos.add(new Periferico("Headset Gamer HyperX Cloud Stinger", "Periférico", 249.90, "HyperX", 20, "P2/P3", "Preto/Vermelho"));
        listaDeProdutos.add(new Periferico("Webcam Logitech C920 Full HD", "Periférico", 399.90, "Logitech", 15, "USB", "Preto"));
        listaDeProdutos.add(new Periferico("Controle Xbox Series Wireless", "Periférico", 449.90, "Microsoft", 10, "USB-C / Bluetooth", "Branco"));
    }


    // Função de cadastro (adicionar/criar) de produto.
    public void adicionarProduto(Produto produtoParaAdicionar) {
        /* Como há duas classes que herdem atributos de produto, foi necesssário o uso do polimorfismo
        pois assim aceita qualquer objeto que seja um Produto
        */
        listaDeProdutos.add(produtoParaAdicionar);
        System.out.println("Novo item adicionado ao estoque com sucesso (código: " + produtoParaAdicionar.getCodigo() + " )" + produtoParaAdicionar.getNome());
    }

    // Função de leitura / exeibição (READ)
    public void listarProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum item foi encontrado no estoque.");
            return;
        }

        System.out.println("------ Inventário do Estoque ------");
        for (Produto item : listaDeProdutos) {
            System.out.println(item); // Isso vai usar o toString da classe Produto
        }
        System.out.println("---------------------------------------");
    }

    // Metodo para facilitar a busca do produto pelo código
    // É utilizado pela classe Main
    public Produto buscarItemPorCodigo(int codigo) {
        Produto produto = null;
        for (Produto item : listaDeProdutos) {
            if (item.getCodigo() == codigo) {
                produto = item; // Retorna o objeto real que está na memória
            }
        }
        return produto;
    }

    //Metodo para verificar se o estoque está vazio
    // Será usado pela classe Main (nas funções update e delete)
    public boolean estaVazio() {
        return this.listaDeProdutos.isEmpty();
    }

    // Função de deletar (Delete)
    public boolean deletarProduto(int codigo) {
        Produto itemParaDeletar = buscarItemPorCodigo(codigo);

        if (itemParaDeletar != null) {
            listaDeProdutos.remove(itemParaDeletar);
            System.out.println("Item '" + itemParaDeletar.getNome() + "' deletado com sucesso.");

            return true;

        }
            System.out.println("Erro: O item com Código " + codigo + " não foi encontrado.");
            System.out.println("Por favor digite um código válido");
            return false;
        }

    }

