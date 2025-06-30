//Importando Recursos Para ter a lista com itens do carrinho
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {
    private EstoqueProdutos estoque;
    private List<Item> itens;
    private double total; // Atributo para armazenar o valor final

    public CarrinhoCompra(EstoqueProdutos estoque) {
        this.estoque = estoque;
        this.itens = new ArrayList<>();
        this.total = 0;
    }

    public void adicionaItem(Item item){
        ProdutoEstoque produtoEmEstoque = estoque.buscaProduto(item.getNomeItem());
        if (produtoEmEstoque != null) {
            this.itens.add(item);
            System.out.println("Item " + item.getNomeItem() + " adicionado.");
        } else {
            System.out.println("Produto " + item.getNomeItem() + " não encontrado no estoque.");
        }
    }

    public void removeItem(String nomeProduto) {
        itens.removeIf(item -> item.getNomeItem().equalsIgnoreCase(nomeProduto));
        System.out.println("Item " + nomeProduto + " removido.");
    }

    // Finaliza a compra, atualizando o estoque
    public void finalizaCompra(){
        System.out.println("Finalizando a compra...");
        for (Item item : itens) {
            //Verifica se o item existe no estoque
            ProdutoEstoque produto = estoque.buscaProduto(item.getNomeItem());
            if (produto != null) {
                // Verifica se a quantidade em estoque é suficiente
                if (produto.getQtdProduto() >= item.getQtdProdutoItem()) {
                    // Atualiza a quantidade no estoque
                    int novaQtd = produto.getQtdProduto() - item.getQtdProdutoItem();
                    produto.setQtdProduto(novaQtd);
                } else {
                    System.out.println("Quantidade de " + produto.getNome() + " insuficiente no estoque.");
                }
            }
        }
    }

    // Calcula o valor total dos itens no carrinho
    public double calculaTotal(){
        this.total = 0; // Zera o total para recalcular
        for (Item item : itens) {
            ProdutoEstoque produto = estoque.buscaProduto(item.getNomeItem());
            if (produto != null) {
                // Soma (preço do produto * quantidade no carrinho)
                this.total += produto.getPreco() * item.getQtdProdutoItem();
            }
        }
        return this.total;
    }

    public void realizarPagamento(MetodoPagamento metodo) {
        double total = this.calculaTotal();
        if (total > 0) {
            boolean sucesso = metodo.processarPagamento(total);
            if (sucesso) {
                System.out.println("Pagamento realizado com sucesso!");
                this.finalizaCompra(); // Efetivamente baixa o estoque
            } else {
                System.out.println("Falha no pagamento. Tente novamente.");
            }
        } else {
            System.out.println("Carrinho vazio, não há o que pagar.");
        }
    }

}
