public abstract class ProdutoEstoque {
    
    //Atributos
    private String nome;
    private double preco;
    private int qtd_produto;
    
    //Construtor
    public ProdutoEstoque(String nome, double preco, int qtd_produto){
        this.nome = nome;
        this.preco = preco;
        this.qtd_produto = qtd_produto;
    }


    //Metodos para acessar os atributos
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getQtdProduto(){
        return qtd_produto;
    }

    //Metodo para atualizar a quantidade
    public void setQtdProduto(int qtd){
        this.qtd_produto = qtd;
    }

    public abstract String exibirDetalhes();
}
