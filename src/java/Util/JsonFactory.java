/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Entity.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Entity.Pedido;
import Model.Entity.Item;

/**
 *
 * @author alunocmc
 */
public class JsonFactory {
    /*
    String dados = "[";

       while (rs.next()) {
          //Retrieve by column name
           String sid = rs.getString("id");
           String sdes = rs.getString("descricao");

           dados += "{id:" + sid + ","
                  + "descricao:" + sdes + "}";
           if (!rs.isLast()) {
               dados += ",";
           }

       }
       dados += "]";
              System.out.println(dados);
    
   
    
              String sid = ""+produtos.get(i).getIdProduto();

*/
    
     public static String getJson(Pedido pedido) throws SQLException{
      String dados = "[id="+pedido.getIdpedido()+",mesa=" + pedido.getMesa() + ",total=" + pedido.calcularValorPedido()+",";
      
      for (int i = 0; i < pedido.getItens().size(); i++){
          dados += "{";
          dados += "nome = " + pedido.getItens().get(i).getProduto().getDescricao() +",";
          dados += "quantidade = " + pedido.getItens().get(i).getQuantidade() +",";
          dados += "subtotal = " + pedido.getItens().get(i).calcularValorItem() +"}";
          if (i != pedido.getItens().size()-1){
              dados += ",";
          }
      }
      dados += "]";
      return dados;
    }
}
