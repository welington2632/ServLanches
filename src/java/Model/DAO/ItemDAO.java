package Model.DAO;

import Model.Entity.Item;
import Model.Entity.Produto;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Everymind
 */
public class ItemDAO {
    
    public static void cadastrarItem(int idPedido, Item item) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("insert into item (id,pedidofk,produtofk,quantidade,valor) values (nextval('seq_item'),?,?,?,?");
        comand.setInt(1, item.getProduto().getIdProduto());
        comand.setInt(2, idPedido);
        comand.setInt(3, item.getQuantidade());
        comand.setDouble(4, item.calcularValorItem());
        comand.execute();
        con.close();
    }
    
    public static Item consultarProduto(int id) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from item where id = ?");
        comand.setInt(1, id);
        ResultSet result = comand.executeQuery();
        Item itemPesquisado = new Item();
        if (result.next()) {
            itemPesquisado = new Item(result.getInt("id"),ProdutoDAO.consultarProduto(result.getInt("produtofk")),result.getInt("quantidade"), result.getDouble("valor"));
        }
        con.close();
        return itemPesquisado;
    }
    
    public static ArrayList<Item> listarItem(int id) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from item where pedidofk = ?");
        comand.setInt(1, id);
        ResultSet result = comand.executeQuery();
        ArrayList<Item> listaItens = new ArrayList<Item>();
        while (result.next()) {
            Item item = new Item(result.getInt("id"),ProdutoDAO.consultarProduto(result.getInt("produtofk")),result.getInt("quantidade"), result.getDouble("valor"));
            listaItens.add(item);
        }
        con.close();
        return listaItens;
    }
    
}
