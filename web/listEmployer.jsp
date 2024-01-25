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



        <main class="container-fluid">
            <div class="row">
                <jsp:include page="navigation.jsp" />

                <aside class="col-md-9 ms-sm-auto col-lg-10 px-md-4">


                    

                </aside>
            </div>
                
        </main>
        <script src="asset/js/index.js"></script>
        <script src="asset/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

