/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

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
 * @author alunocmc
 */
public class ProdutoDAO {
    
    public static void cadastrarProduto(Produto produto) throws ClassNotFoundException, SQLException{
         Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("insert into produto (id,descricao,valor) values (nextval('seq_produto'),?,?)");
        comand.setString(1, produto.getDescricao());
        comand.setDouble(2, produto.getValor());
        comand.execute();
        con.close();
    }
    
    public static List<Produto> listarProduto() throws ClassNotFoundException, SQLException{
         Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from produto");
        
        ResultSet result = comand.executeQuery();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        while (result.next()) {
            Produto produto = new Produto(result.getInt("id"), result.getString("descricao"), result.getDouble("valor"));
            produtos.add(produto);
        }
        con.close();
        return produtos;
    }
    
    public static Produto consultarProduto(int id) throws ClassNotFoundException, SQLException{
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement comand = con.prepareStatement("select * from produto where id = ?");
        comand.setInt(1, id);
        ResultSet result = comand.executeQuery();
        Produto produtoPesquisado = new Produto();
        if (result.next()) {
            produtoPesquisado = new Produto(result.getInt("id"), result.getString("descricao"), result.getDouble("valor"));
        }
        con.close();
        return produtoPesquisado;
    }
}
