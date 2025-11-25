import entidades.ControleEstoque;
import entidades.Hardware;
import entidades.Periferico;
import entidades.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ControleEstoque servico = new ControleEstoque();
        boolean executando = true;

        while (executando) {

            System.out.println("\n===== Gestão de Cadastro de Produtos =====");
            System.out.println("\n===== Selecione umas das opções seguintes: =====");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Listar Itens");
            System.out.println("3. Atualizar Item");
            System.out.println("4. Deletar Item");
            System.out.println("5. Sair");
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


                    // 1. Inicia coletando os dados genéricos da classe mãe (Produto)
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preco: ");
                    double preco = sc.nextDouble();
                    sc.nextLine(); // Limpar o buffer por causa do erro do scanner1
                    System.out.print("Fornecedor: ");
                    String fornecedor = sc.nextLine();
                    System.out.println("Estoque: ");
                    int estoque = sc.nextInt();
                    sc.nextLine();
                    // 2. Coleta dos dados espéc1ificos da subclasse e cria o objeto
                    // Atributos referentes a Hardware
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

                        // metodo que cria Hardware dentro de categoria em produto de forma "automática"
                        Hardware novoHardware = new Hardware(nome, "Hardware", preco, fornecedor, estoque, modelo, garantiMeses, potenciaWatts, especificaoChave);
                        servico.adicionarProduto(novoHardware);

                    } else if (tipo == 2) {
                        // Periférico
                        System.out.println("Conector (Ex: UBS, HDMI): ");
                        String conector = sc.nextLine();
                        System.out.println("Cor: ");
                        String cor = sc.nextLine();

                        // metodo que cria Periférico dentro de categoria em produto de forma "automática"
                        Periferico novoPeriferico = new Periferico(nome, "Periférico", preco, fornecedor, estoque, conector, cor);
                        servico.adicionarProduto(novoPeriferico);
                    }
                    break;

                case 2: // READ
                    servico.listarProdutos();
                    break;

                case 3: // UPDATE
                    if (servico.estaVazio()) {
                        System.out.println("Erro: Não há produtos cadastrados para atualizar");
                        break;
                        // Usa o metodo para realizar uma validação caso a listas esteja vazia
                    }
                    System.out.println("\n--- Atualizar Produto ---");
                    System.out.println("Digite o código do produto para atualizar: ");
                    int idUpdate = sc.nextInt();

                    // Busca o objeto na memória
                    Produto item = servico.buscarItemPorCodigo(idUpdate);

                    if (item == null) {
                        System.out.println("Código do produto não encontrado.");
                        break;
                    }

                    // Inicio do Menu de edição

                    boolean editando = true;
                    while (editando) {
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("Atualizando: " + item.getNome());
                        System.out.println("O que deseja alterar?");
                        System.out.println("1. Nome");
                        System.out.println("2. Preço");
                        System.out.println("3. Fornecedor");
                        System.out.println("4. Estoque");

                        // Opções específicas da subclasse Hardware
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
                                break;
                            case 3:
                                System.out.println("Novo Fornecedor: ");
                                item.setFornecedor(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Novo Estoque: ");
                                item.setEstoque(sc.nextInt());
                                break;

                            // Casos específicos (Atributos de subclasses)
                            case 5:
                                if (item instanceof Hardware) {
                                    System.out.println("Novo Modelo: ");
                                    ((Hardware) item).setModelo(sc.nextLine());
                                } else if (item instanceof Periferico) {
                                    System.out.println("Nova Conector: ");
                                    ((Periferico) item).setConector(sc.nextLine());
                                }
                                break;
                            case 6:
                                if (item instanceof Hardware) {
                                    System.out.println("Nova Garantia (Meses: ");
                                    ((Hardware) item).setGarantiaMeses(sc.nextInt());
                                } else if (item instanceof Periferico) {
                                    System.out.println("Nova Cor: ");
                                    ((Periferico) item).setCor(sc.nextLine());
                                }
                                break;
                            case 7:
                                if (item instanceof Hardware) {
                                    System.out.println("Nova Potência (Watts): ");
                                    ((Hardware) item).setPotenciaWatts(sc.nextInt());
                                }
                                break;
                            case 8:
                                if (item instanceof Hardware) {
                                    System.out.println("Nova Especificação Chave: ");
                                    ((Hardware) item).setEspecificaoChave(sc.nextLine());
                                }
                                break;
                            case 0:
                                editando = false;
                                System.out.println("Alterações Finalizadas.");
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    }
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
