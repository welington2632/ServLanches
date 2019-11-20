package Model.Entity;
public class Produto {
    private int idProduto;
    private String descricao;
    private double valor;

    public Produto(int idProduto, String descricao, double valor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto() {
    } 
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
