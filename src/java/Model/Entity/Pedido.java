/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alunocmc
 */
public class Pedido {

    private int idpedido;
    private int mesa;
    private Date data;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private double valorPedido;

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public double calcularValorPedido() {
        this.valorPedido = 0;
        for (Item item: itens) {
            item.calcularValorItem();
            this.valorPedido += item.getValor();
        }
        return this.valorPedido;
    }

}
