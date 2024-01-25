<%-- 
    Document   : stock
    Created on : 11 janv. 2024, 14:31:11
    Author     : Pc
--%>

<%@page import="dao.EmployerDao"%>
<%@page import="model.Employer"%>
<%@page import="dao.MatierePremiereDao"%>
<%@page import="dao.RequestDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="connection.Connect" %>

<%

    List<Employer> employers = EmployerDao.getAllEmployers();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Employer</title>
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
                                    <h4 class="card-title text-primary">Insert employer</h4>
                                </div>
                                <div class="card-body">
                                    <form id="loginForm" method="POST" action="InsertionEmployerController">
                                        <div class="mb-3">
                                            <label for="role" class="form-label">date debut</label>
                                            <input type="date" class="form-control"  name="dateDebut" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="role" class="form-label">role</label>
                                            <input type="text" class="form-control"  name="role" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="quantiter" class="form-label">salaire horaire</label>
                                            <input type="number" class="form-control"  name="salaireHoraire" required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="role" class="form-label">temps horaire journalier</label>
                                            <input type="number" class="form-control"  name="tempsJournaliere" required>
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
                                <caption>Employer</caption>
                                <tr>
                                    <th>POST</th>
                                    <th>Classe Employer</th>
                                    <th>nombre  Employer</th>
                                    <th>heure de travail journalier</th>
                                </tr>
                                <%  for (Employer emp : employers) {%>
                                <tr>
                                    <td><%= emp.getIdEmployer()%></td>
                                    <td><%= emp.getRoleEmp()%></td>
                                    <td><%= emp.getSalaire()%></td>
                                </tr>
                                <% }%>
                            </table>
                        </div>
                    </div>
                </aside>
            </div>
        </main>
        <script src="asset/js/creation.js"></script>
        <script src="asset/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
