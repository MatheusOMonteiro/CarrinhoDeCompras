// importando recursos para fazer uma lista que contera itens do estoque
import java.util.ArrayList;
import java.util.List;

public class EstoqueProdutos {
    //Atributo: lista de produtos do estoque
    private List<ProdutoEstoque> produtos;

    //Construtor
    public EstoqueProdutos() {
        this.produtos = new ArrayList<>();
    }

    //Adiciona produto na lista
    public void adicionaProduto(ProdutoEstoque produto){
        this.produtos.add(produto);
    }
    
    //Busca produto para ver se ele existe na lista
    public ProdutoEstoque buscaProduto(String nome) {
        for (ProdutoEstoque p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public List<ProdutoEstoque> getProdutos() {
        return produtos; 
    }
}