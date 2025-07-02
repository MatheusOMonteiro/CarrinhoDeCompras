public class Eletronicos extends ProdutoEstoque {
    private int garantiaMeses;

    public Eletronicos(String nome, double preco, int qtd, int garantiaMeses) {
        super(nome, preco, qtd);
        this.garantiaMeses = garantiaMeses;
    }

    @Override // Polimorfismo
    public String exibirDetalhes() {
        return getNome() + " (Garantia: " + garantiaMeses + " meses)";
    }
}
