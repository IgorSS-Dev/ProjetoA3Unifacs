package entidades;

import java.util.ArrayList;
import java.util.List;


public class ControleEstoque {
    private List<Produto> listaDeProdutos = new ArrayList<>();
    public ControleEstoque() {
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));
        this.listaDeProdutos.add(new Produto("Teclado Gamer", "Periferico", "Mancer", 50));

    }
    // "Banco de dados" usando arraylist


    // Função de cadastro (adicionar) de produto.
    public void adicionarProduto(String nome, String categoria, String fornecedor, int estoque) {
        Produto novoProduto = new Produto(nome, categoria, fornecedor, estoque);
        listaDeProdutos.add(novoProduto);
        System.out.println("Novo item adicionado ao estoque com sucesso: " + novoProduto.getNome());
    }

    // Função de leitura / exeibição (READ)
    public void listarProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum item foi encontrado no estoque.");
            return;
        }

        System.out.println("------ Inventário do Almoxarifado ------");
        for (Produto item : listaDeProdutos) {
            System.out.println(item); // Isso vai usar o toString da classe Produto
        }
        System.out.println("---------------------------------------");
    }

    // macete para facilitar a busca do produto pelo código
    private Produto buscarItemPorCodigo(int codigo) {

        for (Produto item : listaDeProdutos) {

            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null; // Para caso não encontre o código
    }
    //macete para verificar se o estoque está vazio
    // Será usado pela classe Main
    public boolean estaVazio() {
        return this.listaDeProdutos.isEmpty();
    }

    // Função de atualizar (Update)
    public boolean atualizarProduto(int codigo, String novoNome, String novaCategoria, String novoFornecedor, int novoEstoque) {
        Produto itemParaAtualizar = buscarItemPorCodigo(codigo);

        if (itemParaAtualizar != null) {
            itemParaAtualizar.setNome(novoNome);
            itemParaAtualizar.setCategoria(novaCategoria);
            itemParaAtualizar.setFornecedor(novoFornecedor);
            itemParaAtualizar.setEstoque(novoEstoque);
            System.out.println("Item " + codigo + " atualizado com sucesso.");
            return true;
        } else {
            System.out.println("Erro: Item com código " + codigo + " não foi encontrado.");
            return false;
        }
    }
    //
    // Função de deletar (Delete)
    public boolean deletarProduto(int codigo) {
        Produto itemParaDeletar = buscarItemPorCodigo(codigo);

        if (itemParaDeletar != null) {
            listaDeProdutos.remove(itemParaDeletar);
            System.out.println("Item '" + itemParaDeletar.getNome() + "' deletado com sucesso.");

            return true;

        } else {
            System.out.println("Erro: Item com Código " + codigo + " não encontrado.");
            return false;
        }
    }
}