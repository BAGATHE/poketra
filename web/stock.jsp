<%-- 
    Document   : stock
    Created on : 11 janv. 2024, 14:31:11
    Author     : Pc
--%>

<%@page import="dao.MatierePremiereDao"%>
<%@page import="dao.RequestDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.MatierePremiere"%>
<%@page import="model.TypePoketra"%>
<%@page import="model.LookPoketra"%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="connection.Connect" %>

<%
    
   
    List<MatierePremiere> materiaux = MatierePremiereDao.getAllMatieres();

    List<List<Object>> stocks =  RequestDb.getStock();


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion stock</title>
        <link href="asset/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="asset/css/home.css">
        <link rel="stylesheet" href="asset/css/dashboard.rtl.css">
    </head>
    <body>

        <header class="navbar sticky-top bg-dark flex-md-nowrap p-0 shadow" data-bs-theme="dark">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white" href="#">Poketra</a>
        </header>

        <main class="container-fluid">
            <div class="row">
                <jsp:include page="navigation.jsp" />

                <aside class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <!--INSERTION DE MATERIAUX-->
                    <div class="row insert justify-content-center" id="materiaux">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title text-primary">Insertion de quantiter materiaux</h4>
                                </div>
                                <div class="card-body">
                                    <form id="loginForm" method="POST" action="InsertionStockMateriaux">
                                        <div class="mb-3">
                                            <label for="inputState" class="form-label">nom matierepremiere</label>
                                            <select id="matiere" class="form-select" name="matiere">
                                                <option selected>Choose...</option>
                                                <%  for (MatierePremiere matiere : materiaux) {%>
                                                <option value="<%= matiere.getIdMPremiere()%>"><%= matiere.getMateriaux()%></option>
                                                <% }%>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label for="quantiter" class="form-label">quantiter </label>
                                            <input type="number" class="form-control"  name="quantiter" required>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Valider">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <table>
                            <tr>
                                <th> id-matiere</th>
                                <th>materiaux</th>
                                <th>prix unitaire</th>
                                <th>quantiter en stock</th>
                                <th></th>
                            </tr>
                            <%  for (List<Object> stock : stocks) {
                            %>
                            <tr>
                                <td><%= stock.get(0)%></td>
                                <td><%= stock.get(1)%></td>
                                <td><%= stock.get(2)%></td>
                                <td><%= stock.get(3)%></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>  
                    </div>
                </aside>
            </div>
        </main>
        <script src="asset/js/creation.js"></script>
        <script src="asset/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
