/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

/**
 *
 * @author alunocmc
 */
public class Item {
    private int idItem;
    private Produto produto;
    private int quantidade;
    private double valor;

    public Item() {
    }

    public Item(int idItem, Produto produto, int quantidade, double valor) {
        this.idItem = idItem;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    
    

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }
    
    public double calcularValorItem(){
        this.valor = this.produto.getValor() * this.quantidade;
        return this.valor;
    }
}
