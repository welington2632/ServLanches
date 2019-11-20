/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunocmc
 */
@WebServlet(urlPatterns = {"/ControleProdutos"})
public class ControleProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String acao = request.getParameter("acao");
  if (acao.equals("buscaTodos")) {
     try {
       String connectString = "jdbc:ucanaccess://" + "c:/Users/alunocmc.ALUNOS/Desktop/ProjetoAula10/banco.accdp";
       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
       Connection conn = DriverManager.getConnection(connectString, "", "");
       Statement stmt = conn.createStatement();

       String sql = "SELECT id,descricao FROM produtos";
       ResultSet rs = stmt.executeQuery(sql);

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
       
       rs.close();
       System.out.println(dados);

   } catch (Exception ex) { }
}


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
