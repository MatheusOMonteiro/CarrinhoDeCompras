public class PagamentoPix implements MetodoPagamento {

    private String chavePixLoja;
    public PagamentoPix(String chavePixLoja){
        this.chavePixLoja = chavePixLoja;
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Gerando QR Code utilizando chave da loja (" + chavePixLoja + "para pagamento PIX no valor de R$" + valor);
        
        return true;
    }
}