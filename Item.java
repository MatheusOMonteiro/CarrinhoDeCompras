public class Item {
    //Atributos
    private String nome;
    private int qtd_produto;

    //Construtor
    public Item(String nome, int qtd){
        this.nome = nome;
        this.qtd_produto = qtd;
    }

    public String getNomeItem(){
        return nome;
    }
    public int getQtdProdutoItem(){
        return qtd_produto;
    }
}
