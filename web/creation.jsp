
<%@page import="dao.EmployerDao"%>
<%@page import="model.Employer"%>
<%@page import="dao.MatierePremiereDao"%>
<%@page import="dao.TypePoketraDao"%>
<%@page import="dao.LookPoketraDao"%>
<%-- 
    Document   : insertion.jsp
    Created on : 19 déc. 2023, 17:15:57
    Author     : Pc
--%>
<%@page import="model.MatierePremiere"%>
<%@page import="model.TypePoketra"%>
<%@page import="model.LookPoketra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="connection.Connect" %>

<%
    List<LookPoketra> looks =  LookPoketraDao.getAllLook();
    
    List<TypePoketra> poketras = TypePoketraDao.getAllType();
    
    List<MatierePremiere> materiaux = MatierePremiereDao.getAllMatieres();
    
    
    List<Employer> employers = EmployerDao.getAllEmployers();



%>


<!doctype html>
<html lang="en" data-bs-theme="auto">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Creation poketra</title>
        <link href="asset/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="asset/css/home.css">
        <link rel="stylesheet" href="asset/css/dashboard.rtl.css">
    </head>
    <body>
        <%            String message = request.getParameter("message");

            if ("success".equals(message)) {
        %>
        <script>
            alert("Création réussie!");
        </script>
        <%
        } else if ("failed".equals(message)) {
        %>
        <script>
            alert("Échec de la création!");
        </script>
        <%
            }
            request.setAttribute("message", null);
        %>

        <header class="navbar sticky-top bg-dark flex-md-nowrap p-0 shadow" data-bs-theme="dark">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6 text-white" href="#">Poketra</a>
        </header>

        <main class="container-fluid">
            <div class="row">
                <jsp:include page="navigation.jsp" />

                <aside class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <form method="POST" action="CreationController">
                        <div class="row col-12 mb-3">
                            <div class="col-md-2">
                                <label for="nom_sac" class="form-label">Nom poketra</label>
                                <input type="text" class="form-control" name="nom" id="nom">
                            </div>
                            <div class="col-md-2">
                                <label for="prix_poketra" class="form-label">Prix poketra</label>
                                <input type="number" class="form-control" name="prix" id="prix">
                            </div>
                            <div class="col-md-2">
                                <label for="inputState" class="form-label">look poketra</label>
                                <select id="look" class="form-select" name="look">
                                    <option selected>Choose...</option>
                                    <%  for (LookPoketra plook : looks) {%>
                                    <option value="<%= plook.getIdLookPoketra()%>"><%= plook.getNomLook()%></option>
                                    <% }%>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="inputState" class="form-label">type poketra</label>
                                <select id="type" class="form-select" name="type">
                                    <option selected>Choose...</option>
                                    <%  for (TypePoketra poketra : poketras) {%>
                                    <option value="<%= poketra.getIdTypePoketra()%>"><%= poketra.getNom()%></option>
                                    <% }%>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="taille" class="form-label">taille</label>
                                <select class="form-select" name="taille" id="taille">
                                    <option selected>Choisir taille</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>
                        </div>
                        <div class="card" style="margin-bottom: 5vh;">
                            <div class="card-header" style="  background-color: rgba(0, 0, 0,0.55);" >
                                <h3 class="card-title text-center" >${category}</h3>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col"></th>
                                            <th scope="col">Materiaux</th>
                                            <th scope="col">Quantiter</th>
                                        </tr>
                                    </thead> 
                                    <tbody class="table-bordered  border-primary">
                                        <%  for (MatierePremiere matiere : materiaux) {%>
                                        <tr>
                                            <th scope="row"><input type="checkbox"  name="choix[]" value="<%= matiere.getIdMPremiere()%>"></th>
                                            <td id="<%= matiere.getIdMPremiere() + "-nom"%>"><%= matiere.getMateriaux()%></td>
                                            <td><input type="number"  class="form-control is-valid" name="<%= matiere.getIdMPremiere()%>" min="1"></td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                                    
                        <div class="card" style="margin-bottom: 5vh;">
                            <div class="card-header" style="  background-color: rgba(0, 0, 0,0.55);" >
                                <h3 class="card-title text-center" >${category}</h3>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col"></th>
                                            <th scope="col">role</th>
                                            <th scope="col">nombre employer</th>
                                               <th scope="col">heure de travail</th>
                                        </tr>
                                    </thead> 
                                    <tbody class="table-bordered  border-primary">
                                        <%  for (Employer emp: employers) {%>
                                        <tr>
                                            <th scope="row"><input type="checkbox"  name="choixEmp[]" value="<%= emp.getIdEmployer()%>"></th>
                                            <td id="<%= emp.getIdEmployer() + "-nom"%>"><%= emp.getRoleEmp() %></td>
                                            <td><input type="number"  class="form-control is-valid" name="<%= emp.getIdEmployer()+"-nombre"%>" min="1"></td>
                                             <td><input type="number"  class="form-control is-valid" name="<%= emp.getIdEmployer()+"-heure"%>" min="1"></td>
                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                                    
                        <div class="btn-group me-2 text-center" style="display:flex; justify-content: center">
                            <button type="button" class="btn btn-lg btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="displaychoice()">CREER</button>
                        </div>


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
                                        <table>
                                            <span style="text-decoration:underline;">Liste des matieres premieres utiliser</span>
                                            <thead>
                                                <tr><th>materiaux</th><th>quantiter</th></tr>
                                            </thead>
                                            <tbody id="listmateriaux">

                                            </tbody>
                                        </table>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Non</button>
                                        <button type="submit" class="btn btn-success" id="traiter">inserer poketra</button>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </form>              
                </aside>
            </div>
        </main>
        <script src="asset/js/creation.js"></script>
        <script src="asset/js/bootstrap.bundle.min.js"></script>
</html>
