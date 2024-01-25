<%-- 
    Document   : listPoketra
    Created on : 24 déc. 2023, 16:09:23
    Author     : Pc
--%>
<%@page import="dao.MatierePremiereDao"%>
<%@page import="dao.InfoPoketraDao"%>
<%@page import="model.MatierePremiere"%>
<%-- 
    Document   : model
    Created on : 12 déc. 2023, 13:27:42
    Author     : Pc
--%>

<%@page import="model.InfoPoketra"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Connect" %>
<%@page import="model.TypePoketra" %>

<%

    List<InfoPoketra> poketras = InfoPoketraDao.getAllPoketra();

    List<MatierePremiere> materiaux = MatierePremiereDao.getAllMatieres();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link href="assets/css/index.css" rel="stylesheet"> 
        <link href="asset/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="asset/css/home.css">
        <link rel="stylesheet" href="asset/css/dashboard.rtl.css">

        <title>Les poketras </title>
    </head>
    <body>
        <header class="navbar sticky-top bg-dark flex-md-nowrap p-0 shadow" data-bs-theme="dark">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white" href="#">Poketra</a>
        </header>



        <%-- Afficher les messages d'erreur ou d'information --%>
        <div class="message-container">
            <% String errorMessage = (String) request.getAttribute("error");
                if (errorMessage != null) {
                    out.println("<p style='color:red;'>" + errorMessage + "</p>");
                    errorMessage = "";
                    request.removeAttribute("error");
                }
            %>
        </div>


        <main class="container-fluid">
            <div class="row">
                <jsp:include page="navigation.jsp" />

                <aside class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

                    <!--recherche materiaux-->
                    <div class="row insert justify-content-center" id="materiaux">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title text-primary">Recherche par tranche de benefice</h4>
                                </div>
                                <div class="card-body">
                                    <form id="loginForm" method="POST" action="searchByPriceController">
                                        <div class="mb-3">
                                            <label for="prix" class="form-label">prixmin </label>
                                            <input type="number" class="form-control"  name="prixmin" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="prix" class="form-label">prixmax </label>
                                            <input type="number" class="form-control"  name="prixmax" required>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Valider">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form method="POST" action="SearchController">
                        <div class="row" style="display: flex; justify-content: space-around" >
                            <div class="col-md-6">
                                <label for="inputState" class="form-label">type poketra</label>
                                <select id="type" class="form-select" name="search">
                                    <option selected>Choose...</option>
                                    <%  for (MatierePremiere matierepre : materiaux) {%>
                                    <option value="<%= matierepre.getIdMPremiere()%>"><%= matierepre.getMateriaux()%></option>
                                    <% }%>
                                </select>
                            </div>
                            <div class="btn-toolbar mb-3" style="margin-left: 70vw">
                                <button type="submit" class="btn btn-success" id="traiter">voir poketra</button>
                            </div>
                        </div>        
                    </form> 

                    <%
                        List<InfoPoketra> searchpoketra = (List<InfoPoketra>) request.getAttribute("resulsearch");

                        if (searchpoketra != null && !searchpoketra.isEmpty()) {
                            // La liste n'est pas null ni vide, affichez les données
                    %>
                    <div class="row">
                        <table>
                            <tr>

                                <th>Nom</th>
                                <th>types</th>
                                <th>look</th>
                                <th>taille</th>
                                <th>prix</th>
                            </tr>
                            <% for (InfoPoketra result : searchpoketra) {
                            %>
                            <tr>

                                <td><%= result.getNom()%></td>
                                <td><%= result.getTypes()%></td>
                                <td><%= result.getLook()%></td>
                                <td><%= result.getTaille()%></td>
                                <td><%= result.getPrix()%></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </table>  
                    </div>

                    <div class="row">
                        <table>
                            <tr>


                                <th>Nom</th>
                                <th>types</th>
                                <th>look</th>
                                <th>taille</th>
                                <th>prixreviens</th>
                                <th>prix</th>
                                <th>quantiter a creer</th>
                                <th></th>
                            </tr>
                            <%                                for (InfoPoketra row : poketras) {
                            %>
                            <tr>


                                <td><%= row.getNom()%></td>
                                <td><%= row.getTypes()%></td>
                                <td><%= row.getLook()%></td>
                                <td><%= row.getTaille()%></td>
                                <td><%= row.getPrixreviens()%></td>
                                <td><%= row.getPrix()%></td>
                            <form method="POST" action="CommandeController">
                                <td><input type="number"  class="form-control is-valid" name="quantiterpoketra" min="1"></td>
                                <td><input type="hidden"  class="form-control is-valid" name="idpoketra" value="<%= row.getIdPoketra()%>"></td>
                                <td> <button type="button" class="btn btn-lg btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal">valider</button></td>


                                <!-- Modal pour afficher la confirmation -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">

                                                <h4 class="modal-title text-center" id="exampleModalLabel">Recapitulation Poketra</h4>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fermer"></button>
                                            </div>
                                            <div class="modal-body">
                                                <section id="para">

                                                </section>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Non</button>
                                                <button type="submit" class="btn btn-success" id="traiter">fabriquer</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>





                            </form>

                            <!--<td> <button type="submit" onclick="" class="btn btn-warning" >modifier</button></td>
                            <td> <button type="submit" onclick="" class="btn btn-danger" >Supprimer</button></td> -->
                            </tr>
                            <%
                                }
                            %>
                        </table> 

                    </div>

                </aside>
            </div>



            <%
                List<InfoPoketra> resulsearchbyprice = (List<InfoPoketra>) request.getAttribute("resulsearchbyprice");

                if (resulsearchbyprice != null && !resulsearchbyprice.isEmpty()) {
                    // La liste n'est pas null ni vide, affichez les données
            %>
            <div class="row">
                <table>
                    <tr>

                        <th>Nom</th>
                        <th>types</th>
                        <th>look</th>
                        <th>taille</th>
                        <th>prix</th>
                        <th>benefice</th>
                    </tr>
                    <% for (InfoPoketra result : resulsearchbyprice) {
                    %>
                    <tr>

                        <td><%= result.getNom()%></td>
                        <td><%= result.getTypes()%></td>
                        <td><%= result.getLook()%></td>
                        <td><%= result.getTaille()%></td>
                        <td><%= result.getPrix()%></td>
                        <td><%=  result.getPrix() - result.getPrixreviens()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>  
            </div>


        </main>
        <script src="asset/js/index.js"></script>
        <script src="asset/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
