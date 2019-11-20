package Controller;

import Model.DAO.ProdutoDAO;
import Model.Entity.Produto;
import Util.JsonFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerPedido", urlPatterns = {"/ControllerPedido","/ListarItensPedido"})
public class ControllerPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/ListarItensPedido")) {
            ListarItensPedido(request, response);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    public void ListarItensPedido(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Produto> produtoLista = ProdutoDAO.listarProduto();
            //String jsonProduto = JsonFactory.getJson(produtoLista);
            //request.setAttribute("mensagem", jsonProduto);
                request.getRequestDispatcher("/resposta.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
