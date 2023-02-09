<%@ page import="models.Member" %>
<%@ page import="services.ClassService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Class" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>When Is My Code Review?</title>

    <!-- Bootstrap CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./resources/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<%@ include file="header.jsp"%>
<body>

<div id="wrapper">

    <div id="page-wrapper" class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Creer une classe</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <!-- /.panel -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <form action="<%= request.getContextPath() %>/AddClasse" method="post" class="">
                                    <div class="form-group">
                                        <label for="classname">Nom de Classe</label>
                                        <input required type="text" class="input-lg form-control" id="classname" name="classname"  placeholder="Nom de Classe">
                                    </div>
                                    <div class="form-group">
                                        <label for="member">Nombre de Membres</label>
                                        <input required type="number" min="0" class="input-lg form-control" id="member" name="member" placeholder="Nombre de Membres">

                                    </div>

                                    <div class="text-right">
                                        <button type="submit" class="btn btn-lg btn-primary">Enregistrer</button>
                                    </div>


                                </form>
                            </div>
                            <% if(request.getAttribute("error")!=null){%>
                            <p>
                                <%= request.getAttribute("error") %>
                            </p>
                            <%}%>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- jQuery -->
<script src="../js/jquery-3.1.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>


</body>
    <%@ include file="footer.jsp"%>
</html>
