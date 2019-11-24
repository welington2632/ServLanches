package Controller;

import Model.DAO.ProdutoDAO;
import Model.Entity.Item;
import Model.Entity.Pedido;
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

@WebServlet(name = "ControllerPedido", urlPatterns = {"/ControllerPedido","/ListarItensPedido","/InserirProduto"})
public class ControllerPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String uri = request.getRequestURI();
        if (uri.equals(request.getContextPath() + "/ListarItensPedido")) {
            ListarItensPedido(request, response);
        } else if (uri.equals(request.getContextPath() + "/InserirProduto")) {
            inserirProduto(request, response);
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
    
    public void inserirProduto(HttpServletRequest request, HttpServletResponse response){
        try {
                Pedido pedido = (Pedido) request.getAttribute("pedidoAtivo");
                Item itemAdicionar = new Item();
                itemAdicionar.setProduto(ProdutoDAO.consultarProduto(Integer.parseInt(request.getParameter("id"))));
                itemAdicionar.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                boolean insereNovoItem = true;
                
                // Verifica se o item já é existente em pedido para somente adicionar
                for (Item item : pedido.getItens()){
                    if (item.getProduto().getIdProduto() == itemAdicionar.getProduto().getIdProduto()) {
                        insereNovoItem = false;
                        item.setQuantidade(item.getQuantidade() + itemAdicionar.getQuantidade());
                        item.calcularValorItem();
                    }
                }
                
                // Caso o produto não esteja cadastrado no pedido, ele irá adicionar
                if (insereNovoItem){
                itemAdicionar.calcularValorItem();
                pedido.getItens().add(itemAdicionar);
                }
                
                pedido.calcularValorPedido();
                request.setAttribute("pedidoAtivo", pedido);
                request.getRequestDispatcher("/pedido.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
