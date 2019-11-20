<%-- 
    Document   : cadastroProduto
    Created on : 20/11/2019, 20:03:20
    Author     : Everymind
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pedido</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" type="text/css" href="css/cadastroPedido.js">

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/cadastroPedido.js"></script>
    </head>
    <body>
        <script src = "//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js" ></script>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 table-responsive">
                    <table class="table table-bordered table-hover table-sortable" id="tab_logic">
                        <thead>
                            <tr >
                                <th class="text-center">
                                    Quantidade
                                </th>
                                <th class="text-center">
                                    produto
                                </th>
                                <th class="text-center" style="border-top: 1px solid #ffffff; border-right: 1px solid #ffffff;">
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id='addr0' data-id="0" class="hidden">
                                <td data-name="name">
                                    <input type="number" name='name0'  placeholder='Quantidade' class="form-control"/>
                                </td>
                                
                                <td data-name="sel">
                                    <select name="sel0">
                                        <option value="">Selecione o Produto</option>
                                        <option value="1">Uva/option>
                                        <option value="2">Pera/option>
                                        <option value="3">Maça/option>
                                    </select>
                                </td>
                                <td data-name="del">
                                    <button name="del0" class='btn btn-danger glyphicon glyphicon-remove row-remove'><span aria-hidden="true">×</span></button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <a id="add_row" class="btn btn-primary float-right">Criar Pedido</a>
        </div>

    </body>
</html>
