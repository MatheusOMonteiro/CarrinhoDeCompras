public class Principal {
    public static void main(String[] args) {

        //Criando Estoque dos produtos
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.adicionaProduto(new Hardware("Placa de Vídeo RTX 4090", 9500.00, 10, 24, 450.0));
        estoque.adicionaProduto(new Hardware("Processador Ryzen 9", 2800.00, 15, 36, 170.0));
        estoque.adicionaProduto(new Perifericos("Mouse Gamer G502", 350.00, 50, 12, "Preto"));
        estoque.adicionaProduto(new Perifericos("Teclado Mecânico K8", 450.00, 30, 18, "Branco"));
        System.out.println("--- Detalhes dos Produtos em Estoque ---");
        for (ProdutoEstoque p : estoque.getProdutos()) {
            System.out.println("- " + p.exibirDetalhes() + " - R$" + p.getPreco() + " - " + p.getQtdProduto());
        }
        System.out.println();


        
        //Iniciando Etapa de Compra
        System.out.println("--- Cliente Iniciando a Compra ---");
        CarrinhoCompra carrinhoDoJoao = new CarrinhoCompra(estoque);
        Cliente clienteJoao = new Cliente("João da Silva", carrinhoDoJoao);
        System.out.println("Cliente: " + clienteJoao.getNomeCliente());

        //Adicionando itens no carrinho
        carrinhoDoJoao.adicionaItem(new Item("Placa de Vídeo RTX 4090", 1));
        carrinhoDoJoao.adicionaItem(new Item("Teclado Mecânico K8", 1));
        // Testando adicionar um item que não existe para ver a mensagem de erro
        carrinhoDoJoao.adicionaItem(new Item("Monitor 4K", 1)); 
        System.out.println();


        //Calculando total e finalizando
        System.out.println("--- Fechamento do Pedido e Pagamento ---");
        double total = carrinhoDoJoao.calculaTotal();
        System.out.println("Valor total do carrinho: R$" + String.format("%.2f", total));

        // Criando as instâncias de pagamento
        MetodoPagamento pagamentoComCartao = new PagamentoCartao(123456789);
        MetodoPagamento pagamentoComPix = new PagamentoPix("123123123123");

        // Cliente escolhe pagar com cartão
        System.out.println("--> Tentando pagar com Cartão de Crédito...");
        carrinhoDoJoao.realizarPagamento(pagamentoComCartao);
        System.out.println();
        

        
        System.out.println("--- Verificação do Estoque Pós-Venda ---");
        for (ProdutoEstoque p : estoque.getProdutos()) {
            System.out.println("- " + p.getNome() + " | Quantidade restante: " + p.getQtdProduto());
        }
    }
}