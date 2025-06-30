public class Perifericos extends Eletronicos{
    private String cor;

    public Perifericos(String nome, double preco, int qtd, int garantiaMeses, String cor) {
        super(nome, preco, qtd, garantiaMeses);
        this.cor  = cor;
    }

    @Override // Polimorfismo
    public String exibirDetalhes() {
        // Adicionado o ")" no final
        return getNome() + " (cor: " + cor + ")"; 
    }

}
