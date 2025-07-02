public class Cliente {
    //Atributos
    private String nome;
    private CarrinhoCompra carrinho;

    //Construtor
    public Cliente(String nome, CarrinhoCompra carrinho){
        this.nome = nome;
        this.carrinho = carrinho;
    }

    public String getNomeCliente(){
        return nome;
    }

    public CarrinhoCompra getCarrinhoCliente(){
        return carrinho;
    }

}
