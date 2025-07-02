public class PagamentoCartao implements MetodoPagamento{
    private int numeroCartao;

    public PagamentoCartao(int numeroCartao){
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando R$" + valor + " no cartão " + numeroCartao);
        return true; // Supondo que o pagamento foi aprovado
    }
}
