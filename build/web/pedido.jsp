<%-- 
    Document   : pedido
    Created on : 24/11/2019, 20:35:53
    Author     : Vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body p-0">
                    <div class="row p-5">
                        <div class="col-md-6">
                            <img src="http://via.placeholder.com/400x90?text=logo">
                        </div>

                        <div class="col-md-6 text-right">
                            <p class="font-weight-bold mb-1">Invoice #550</p>
                            <p class="text-muted">Due to: 4 Dec, 2019</p>
                        </div>
                    </div>

                    <hr class="my-5">

                    <div class="row p-5">
                        <div class="col-md-12">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="border-0 text-uppercase small font-weight-bold">ID</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Item</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Quantity</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Unit Cost</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Software</td>
                                        <td>21</td>
                                        <td>$321</td>
                                        <td>$3452</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="d-flex flex-row-reverse bg-dark text-white p-4">
                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Grand Total</div>
                            <div class="h2 font-weight-light">$234,234</div>
                        </div>

                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Discount</div>
                            <div class="h2 font-weight-light">10%</div>
                        </div>

                        <div class="py-3 px-5 text-right">
                            <div class="mb-2">Sub - Total amount</div>
                            <div class="h2 font-weight-light">$32,432</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="text-light mt-5 mb-5 text-center small">by : <a class="text-light" target="_blank" href="http://totoprayogo.com">totoprayogo.com</a></div>

</div>
    </body>
</html>
