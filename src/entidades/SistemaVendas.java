package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaVendas {

    public void realizarVenda(ControleEstoque estoque, FluxoCaixa caixa) {
        Scanner sc = new Scanner(System.in);
        List<ItemCarrinho> carrinho = new ArrayList<>();
        boolean comprando = true;

        System.out.println("---- Nova Venda ----");

        // Laço de repetição para adicionar os produtos ao "carrinho"
        while (comprando) {
            estoque.listarProdutos(); // Mostra a lista de produtos disponíveis
            System.out.println("Digite o código do produto: ");
            int cod = sc.nextInt();

            Produto prod = estoque.buscarItemPorCodigo(cod);

            if (prod != null) {
                System.out.println("Selecionado: " + prod.getNome() + " | Preço: R$ " + prod.getPreco());
                System.out.println("Quantidade: ");
                int qtd = sc.nextInt();
                sc.nextLine(); // Limpa o buffer

                // Aqui é feito uma regra para a quantidade não possa ser 0 ou maior que o que consta no estoque
                if (qtd > 0 && qtd <= prod.getEstoque()) {
                    carrinho.add(new ItemCarrinho(prod, qtd));
                    System.out.println("Produto adicionado com sucesso!");
                } else {
                    System.out.println("Quantidade inválida ou estoque insuficiente");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
            // Pergunta ao usuário se deseja continuar
            System.out.println("Deseja adicionar outro produto? (1. Sim / 0. Não");
            int continuar = sc.nextInt();
            if (continuar == 0) {
                comprando = false;
            }
            // Finaliza a compra (Caso tenha itens no carrinho)
            if (!carrinho.isEmpty()) {
                double totalVenda = 0;
                System.out.println("--- Nota Fiscal ---");

                // Abate a quantidade do estoque
                for (ItemCarrinho item : carrinho) {
                    Produto p = item.getProduto();
                    p.setEstoque(p.getEstoque() - item.getQuantidade());

                    // Soma o valor total
                    totalVenda += item.getSubtotal();

                    System.out.printf("%s (x%d) - R$ %.2f\n", p.getNome(), item.getQuantidade(), item.getSubtotal());

                }

                caixa.registrarVenda(totalVenda);
                System.out.println("-------------------------");
                System.out.printf("Valor total a Pagar: R$ %.2f\n", totalVenda);
                System.out.println("Venda finalizada e estoque atualizado!");
            } else {
                System.out.println("Venda cancelada (carrinho está vazio).");
            }

        }

    }
}
