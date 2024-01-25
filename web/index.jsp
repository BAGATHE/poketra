<%-- 
    Document   : insertion.jsp
    Created on : 19 déc. 2023, 17:15:57
    Author     : Pc
--%>
<%@page import="dao.TypePoketraDao"%>
<%@page import="dao.MatierePremiereDao"%>
<%@page import="dao.LookPoketraDao"%>
<%@page import="model.MatierePremiere"%>
<%@page import="model.TypePoketra"%>
<%@page import="model.LookPoketra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="connection.Connect" %>

<%
   
    List<LookPoketra> looks = LookPoketraDao.getAllLook();
   
    List<TypePoketra> poketras = TypePoketraDao.getAllType();
   
    List<MatierePremiere> materiaux = MatierePremiereDao.getAllMatieres();
%>


<!doctype html>
<html lang="en" data-bs-theme="auto">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gestion Matiere</title>
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
                    <!-- <section id="choixInsertion">-->
                    <div class="pt-3 pb-2 mb-3 border-bottom" style="display: flex; justify-content: center">
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-lg btn-outline-secondary" name="look">INSERER UNE NOUVELLE LOOK</button>
                            </div>
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-lg btn-outline-secondary" name="materiaux">INSERER UNE NOUVELLE MATIERE</button>
                            </div>
                            <div class="btn-group me-2">
                                <button type="button" class="btn btn-lg btn-outline-secondary" name="typepo">INSERER UNE NOUVELLE TYPE</button>
                            </div>
                        </div>
                    </div> 

                    <!--INSERTION DE NOUVELLE LOOK-->
                    <div class="row justify-content-center insert" id="look" style="display: none">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title text-primary">Insertion de nouvelle Look</h4>
                                </div>
                                <div class="card-body">
                                    <form method="POST" action="InsertionController">
                                        <div class="mb-3">
                                            <label for="nom" class="form-label">Nom look</label>
                                            <input type="text" class="form-control"  name="look" required>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Valider">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--INSERTION DE NOUVELLE TYPE-->
                    <div class="row justify-content-center insert" id="typepo" style="display: none">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title text-primary">Insertion de nouvelle type</h4>
                                </div>
                                <div class="card-body">
                                    <form id="loginForm" method="POST" action="InsertionController">
                                        <div class="mb-3">
                                            <label for="nom" class="form-label">Nom Type</label>
                                            <input type="text" class="form-control"  name="typepoketra" required>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Valider">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--INSERTION DE MATERIAUX-->
                    <div class="row insert justify-content-center" id="materiaux" style="display: none">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title text-primary">Insertion de Materiaux</h4>
                                </div>
                                <div class="card-body">
                                    <form id="loginForm" method="POST" action="InsertionController">
                                        <div class="mb-3">
                                            <label for="nom" class="form-label">Materiaux</label>
                                            <input type="text" class="form-control"  name="materiaux" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="prix" class="form-label">prix </label>
                                            <input type="number" class="form-control"  name="prixm" required>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Valider">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <!-- Premier tableau -->

                            <table class="table table-primary">
                                <caption>look</caption>
                                <tr>
                                    <th>id</th>
                                    <th>look Poketra</th>
                                </tr>
                                <%  for (LookPoketra lookp : looks) {%>
                                <tr>
                                    <td><%= lookp.getIdLookPoketra()%></td>
                                    <td><%= lookp.getNomLook()%></td>
                                </tr>
                                <% }%>
                            </table>
                            <form id="loginForm" method="POST" action="SearchGeneral">
                                <div class="mb-3">
                                    <label for="nom" class="form-label">recherche look</label>
                                    <input type="text" class="form-control"  name="lookpoketra" required>
                                </div>
                                <input type="submit" class="btn btn-primary" value="Valider">
                            </form>
                        </div>
                        <div class="col">
                            <!-- Deuxième tableau -->
                            <table class="table table-hover">
                                <caption>matiere premiere</caption>
                                <tr>
                                    <th>id</th>
                                    <th>materiaux</th>
                                    <th>Prix</th>
                                </tr>
                                <%  for (MatierePremiere matiere : materiaux) {%>
                                <tr>
                                    <td><%= matiere.getIdMPremiere()%></td>
                                    <td><%= matiere.getMateriaux()%></td>
                                    <td><%= matiere.getPrix()%></td>
                                </tr>
                                <% }%>
                            </table>
                            <form id="loginForm" method="POST" action="SearchGeneral">
                                <div class="mb-3">
                                    <label for="nom" class="form-label">recherche materiaux</label>
                                    <input type="text" class="form-control"  name="materiaux" required>
                                </div>
                                <input type="submit" class="btn btn-primary" value="Valider">
                            </form>
                        </div>
                        <div class="col">
                            <!-- Troisième tableau -->
                            <table class="table table-info">
                                <caption>type</caption>
                                <tr>
                                    <th>id</th>
                                    <th>type poketra</th>
                                </tr>
                                <%  for (TypePoketra poketra : poketras) {%>
                                <tr>
                                    <td><%= poketra.getIdTypePoketra()%></td>
                                    <td><%= poketra.getNom()%></td>
                                </tr>
                                <% }%>
                            </table>
                            <form id="loginForm" method="POST" action="SearchGeneral">
                                <div class="mb-3">
                                    <label for="nom" class="form-label">type poketra</label>
                                    <input type="text" class="form-control"  name="typepoketra" required>
                                </div>
                                <input type="submit" class="btn btn-primary" value="Valider">
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <h6>valiny recherche anaty tableau</h6>             
                    </div>
                </aside>
            </div>
        </main>
        <script src="asset/js/index.js"></script>
        <script src="asset/js/bootstrap.bundle.min.js"></script>
</html>
