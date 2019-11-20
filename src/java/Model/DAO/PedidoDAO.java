/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Entity.Pedido;
import Model.Entity.Produto;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.DAO.ProdutoDAO;
import Model.Entity.Item;
import Model.DAO.ItemDAO;

/**
 *
 * @author Everymind
 */
public class PedidoDAO {
    
    public static void cadastrarPedido(Pedido pedido) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionFactory.getConexao();
        for (Item item : pedido.getItens()){
            ItemDAO.cadastrarItem(pedido.getIdpedido(), item);
        }
        PreparedStatement comand = con.prepareStatement("insert into pedido (id, mesa, data, valorpedido) values (nextval('seq_pedido'),?,CURDATE(),?)");
        comand.setInt(1, pedido.getMesa());
        comand.setDouble(2, pedido.calcularValorPedido());
        comand.execute();
        con.close();
    }
    
    public static Pedido consultaPedido(int id) throws ClassNotFoundException, SQLException{
         Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from pedido where id = ?");
        comand.setInt(1, id);
        ResultSet result = comand.executeQuery();
        Pedido pedido = new Pedido();
        if (result.next()) {
        pedido.setData(result.getDate("data"));
        pedido.setMesa(result.getInt("mesa"));
        pedido.setItens(ItemDAO.listarItem(id));
        pedido.setIdpedido(id);
        }
        con.close();
        return pedido;
    }
}
