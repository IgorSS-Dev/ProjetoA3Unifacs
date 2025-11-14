import entidades.ControleEstoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ControleEstoque servico = new ControleEstoque();
        boolean executando = true;

        // (codigo, nome, categoria, fornecedor, estoque)

        while (executando) {

            System.out.println("\n===== Gestão de Almoxarifado =====");
            System.out.println("1. Adicionar Item (Create)");
            System.out.println("2. Listar Itens (Read)");
            System.out.println("3. Atualizar Item (Update)");
            System.out.println("4. Deletar Item (Delete)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do nextInt()

            switch (opcao) {
                case 1: // CREATE

                    System.out.println("\n--- Adicionar Novo Item ---");


                    // System.out.print("Código: ");
                   // int codigo = sc.nextInt();
                   // sc.nextLine(); // Limpa o buffer do nextInt()

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Fornecedor: ");
                    String fornecedor = sc.nextLine();



                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer do nextInt()


                    servico.adicionarProduto(nome, categoria, fornecedor, estoque);
                    break;

                case 2: // READ
                    servico.listarProdutos();
                    break;

                case 3: // UPDATE

                    if (servico.estaVazio()) {
                        System.out.println("Não há produtos cadastrados para atualizar ");
                        break; // Para sair do switch e voltar ao menu
                    }

                    System.out.println("\n--- Atualizar Item ---");
                    System.out.print("Digite o código do item para atualizar: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer

                    System.out.print("Novo Nome: ");

                    String novoNome = sc.nextLine();
                    System.out.print("Nova Categoria: ");
                    String novaCategoria = sc.nextLine();
                    System.out.print("Novo Fornecedor: ");
                    String novoFornecedor = sc.nextLine();



                    System.out.print("Novo Estoque: ");
                    int novoEstoque = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer do nextInt()


                    servico.atualizarProduto(idUpdate, novoNome, novaCategoria, novoFornecedor, novoEstoque);
                    break;

                case 4: // DELETE

                    if (servico.estaVazio()) {
                        System.out.println("Não há produtos cadastrados para deletar ");
                        break; // Para sair do switch e voltar ao menu
                    }

                    System.out.println("\n--- Deletar Item ---");
                    System.out.print("Digite o código do produto para deletar: ");
                    int idDelete = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer

                    servico.deletarProduto(idDelete);
                    break;

                case 5:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");


            }
        }
        sc.close();
    }
}