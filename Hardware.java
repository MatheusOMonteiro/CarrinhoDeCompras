public class Hardware extends Eletronicos{
    private double consumoEnergia;

    public Hardware(String nome, double preco, int qtd, int garantiaMeses, double consumoEnergia) {
        super(nome, preco, qtd, garantiaMeses);
        this.consumoEnergia  = consumoEnergia;
    }

    @Override // Polimorfismo
    public String exibirDetalhes() {
        // Adicionado o ")" no final
        return getNome() + " (Consumo Energia: " + consumoEnergia + ")"; 
    }
}
