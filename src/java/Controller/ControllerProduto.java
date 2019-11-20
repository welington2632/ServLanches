
package Controller;

import Model.DAO.ProdutoDAO;
import Model.Entity.Item;
import Model.Entity.Pedido;
import Model.Entity.Produto;
import Util.JsonFactory;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControllerProduto", urlPatterns = {"/ListarProduto"})
public class ControllerProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/ListarProduto")) {
            ListarProduto(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    public void ListarProduto(HttpServletRequest request, HttpServletResponse response){
        try {
            Produto produto = new Produto();
            produto.setIdProduto(1);
            produto.setDescricao("Uva");
            produto.setValor(10);
            Item item = new Item();
            item.setIdItem(1);
            item.setProduto(produto);
            item.setQuantidade(10);
            Pedido pedido = new Pedido();
            pedido.setIdpedido(1);
            ArrayList<Item> listaItem = new ArrayList<Item>();
            listaItem.add(item);            
            pedido.setItens(listaItem);
            pedido.setMesa(4);
            String jsonProduto = JsonFactory.getJson(pedido);
            request.setAttribute("mensagem", jsonProduto);
                request.getRequestDispatcher("/resposta.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
