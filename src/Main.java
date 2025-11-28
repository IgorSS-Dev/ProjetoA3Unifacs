import entidades.ControleEstoque;
import entidades.Hardware;
import entidades.Periferico;
import entidades.Produto;
import entidades.FluxoCaixa;
import entidades.SistemaVendas;


import java.util.Scanner;

public class Main {
    // As funções estão dentro da classe main porque eles precisam
    // ficar visíveis para todos os metodos da classe

    private static Scanner sc = new Scanner(System.in);
    private static ControleEstoque servico = new ControleEstoque();
    private static FluxoCaixa caixa = new FluxoCaixa();
    private static SistemaVendas vendas = new SistemaVendas();

    public static void main(String[] args) {

        boolean sistemaAtivo = true;
        while (sistemaAtivo) {
            System.out.println("----------------------------------------------------------");
            System.out.println("**** Menu Geral     ****");
            System.out.println("----------------------------------------------------------");
            System.out.println("1. Gestão de Estoque (Cadastro)");
            System.out.println("2. Carrinho de Compras / Realizar Venda");
            System.out.println("3. Consultar Fluxo de Caixa");
            System.out.println("0. Sair do Sistema");

            System.out.print("Escolha uma opção: ");
            int opcaoMaster = sc.nextInt();

            sc.nextLine(); // Limpa buffer

            switch (opcaoMaster) {
                case 1: // Inicia o menu de cadastro
                    boolean executando = true;

                    while (executando) {
                        System.out.println("\n===== Gestão de Cadastro de Produtos =====");
                        System.out.println("1. Adicionar Item");
                        System.out.println("2. Listar Itens");
                        System.out.println("3. Atualizar Item");
                        System.out.println("4. Deletar Item");
                        System.out.println("5. Retornar ao Menu Principal");
                        System.out.print("Escolha uma opção: ");

                        int opcao = sc.nextInt();
                        sc.nextLine(); // Limpa o buffer do nextInt()

                        switch (opcao) {
                            case 1: // CREATE
                                System.out.println("\n--- Adicionar Novo Item ---");
                                System.out.println("Qual o tipo do produto?");
                                System.out.println("1. Hardware");
                                System.out.println("2. Periférico");
                                System.out.println("Opção: ");
                                int tipo = sc.nextInt();
                                sc.nextLine(); // Limpa o buffer

                                System.out.print("Nome: ");
                                String nome = sc.nextLine();
                                System.out.print("Preco: ");
                                double preco = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Fornecedor: ");
                                String fornecedor = sc.nextLine();
                                System.out.println("Estoque: ");
                                int estoque = sc.nextInt();
                                sc.nextLine();

                                if (tipo == 1) {
                                    System.out.println("Modelo Técinico (Ex: 1650TI...): ");
                                    String modelo = sc.nextLine();
                                    System.out.println("Garantia (Meses): ");
                                    int garantiMeses = sc.nextInt();
                                    System.out.println("Potência (Watts): ");
                                    int potenciaWatts = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Especificação Chave (Ex: Socket LGA1155): ");
                                    String especificaoChave = sc.nextLine();

                                    Hardware novoHardware = new Hardware(nome, "Hardware", preco, fornecedor, estoque, modelo, garantiMeses, potenciaWatts, especificaoChave);
                                    servico.adicionarProduto(novoHardware);

                                } else if (tipo == 2) {
                                    System.out.println("Conector (Ex: UBS, HDMI): ");
                                    String conector = sc.nextLine();
                                    System.out.println("Cor: ");
                                    String cor = sc.nextLine();

                                    Periferico novoPeriferico = new Periferico(nome, "Periférico", preco, fornecedor, estoque, conector, cor);
                                    servico.adicionarProduto(novoPeriferico);
                                    // CORREÇÃO: Removido o 'break' que estava aqui dentro do if, pois era redundante
                                }
                                break; // Break do Case 1 (Create)

                            case 2: // READ
                                servico.listarProdutos();
                                break;

                            case 3: // UPDATE
                                if (servico.estaVazio()) {
                                    System.out.println("Erro: Não há produtos cadastrados para atualizar");
                                    break;
                                }
                                System.out.println("\n--- Atualizar Produto ---");
                                System.out.println("Digite o código do produto para atualizar: ");
                                int idUpdate = sc.nextInt();
                                sc.nextLine(); // Buffer extra adicionado por segurança

                                Produto item = servico.buscarItemPorCodigo(idUpdate);

                                if (item == null) {
                                    System.out.println("Erro: Código do produto não encontrado.");
                                    break;
                                }

                                boolean editando = true;
                                while (editando) {
                                    System.out.println("\n---------------------------------------------------");
                                    System.out.println("Atualizando: " + item.getNome());
                                    System.out.println("O que deseja alterar?");
                                    System.out.println("1. Nome");
                                    System.out.println("2. Preço");
                                    System.out.println("3. Fornecedor");
                                    System.out.println("4. Estoque");

                                    if (item instanceof Hardware) {
                                        System.out.println("5. Modelo Técnico");
                                        System.out.println("6. Garantia");
                                        System.out.println("7. Potência");
                                        System.out.println("8. Especificação Chave");
                                    } else if (item instanceof Periferico) {
                                        System.out.println("5. Conector");
                                        System.out.println("6. Cor");
                                    }

                                    System.out.println("0. Sair e Salvar");
                                    System.out.println("Opção: ");
                                    int opEditar = sc.nextInt();
                                    sc.nextLine(); // Limpa o buffer

                                    switch (opEditar) {
                                        case 1:
                                            System.out.println("Novo Nome: ");
                                            item.setNome(sc.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("Novo Preço: ");
                                            item.setPreco(sc.nextDouble());
                                            sc.nextLine(); // Buffer para double
                                            break;
                                        case 3:
                                            System.out.println("Novo Fornecedor: ");
                                            item.setFornecedor(sc.nextLine());
                                            break;
                                        case 4:
                                            System.out.println("Novo Estoque: ");
                                            item.setEstoque(sc.nextInt());
                                            sc.nextLine(); // Buffer para int
                                            break;
                                        case 5:
                                            if (item instanceof Hardware) {
                                                System.out.println("Novo Modelo: "); ((Hardware) item).setModelo(sc.nextLine());
                                            } else if (item instanceof Periferico) {
                                                System.out.println("Nova Conector: "); ((Periferico) item).setConector(sc.nextLine());
                                            }
                                            break;
                                        case 6:
                                            if (item instanceof Hardware) {
                                                System.out.println("Nova Garantia (Meses): "); ((Hardware) item).setGarantiaMeses(sc.nextInt()); sc.nextLine();
                                            } else if (item instanceof Periferico) {
                                                System.out.println("Nova Cor: "); ((Periferico) item).setCor(sc.nextLine());
                                            }
                                            break;
                                        case 7:
                                            if (item instanceof Hardware) {
                                                System.out.println("Nova Potência (Watts): "); ((Hardware) item).setPotenciaWatts(sc.nextInt()); sc.nextLine();
                                            }
                                            break;
                                        case 8:
                                            if (item instanceof Hardware) {
                                                System.out.println("Nova Especificação Chave: "); ((Hardware) item).setEspecificaoChave(sc.nextLine());
                                            }
                                            break;
                                        case 0:
                                            editando = false;
                                            System.out.println("Alterações Finalizadas.");
                                            break;
                                        default:
                                            System.out.println("Opção inválida");
                                    }
                                    // CORREÇÃO: O 'break' que estava aqui foi removido para o loop while(editando) continuar rodando até digitar 0
                                }
                                break; // Break do Case 3 (Update)

                            case 4: // DELETE
                                if (servico.estaVazio()) {
                                    System.out.println("Não há produtos cadastrados para deletar ");
                                    break;
                                }
                                System.out.println("\n--- Deletar Item ---");
                                System.out.print("Digite o código do produto para deletar: ");
                                int idDelete = sc.nextInt();
                                sc.nextLine(); // Limpa o buffer
                                servico.deletarProduto(idDelete);
                                break;

                            case 5: // RETORNAR
                                executando = false;
                                System.out.println("Voltando ao Menu Principal...");
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                        // CORREÇÃO: O 'break' que estava aqui foi removido para o loop while(executando) continuar rodando
                    }
                    break; // CORREÇÃO: Adicionado break OBRIGATÓRIO do Case 1 (Menu Estoque) para não cair no Case 2 (Vendas)

                case 2:
                    // CORREÇÃO: Adicionado o parâmetro 'sc' que faltava
                    vendas.realizarVenda(servico, caixa);
                    break;

                case 3:
                    System.out.println("--- Fluxo de Caixa ---");
                    System.out.printf("Saldo Total Acumulado: R$ %.2f\n", caixa.getSaldoTotal());
                    System.out.println("------------------------");
                    break;

                case 0:
                    sistemaAtivo = false;
                    System.out.println("Encerrando Sistema");
                    break;

                default:
                    System.out.println("Opção Inválida");
            }
        }
        sc.close();
    }
}