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

    <body>
    <% ClassService classService = new ClassService();
        Member member = (Member)request.getAttribute("member");
    %>

    <div id="wrapper">

        <div id="page-wrapper" class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Ajouter un membre</h1>
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
                                    <form action="<%= request.getContextPath() %>/updateMember" method="post" class="">
                                        <div class="form-group">
                                            <label for="name">Nom</label>
                                            <input required type="text" class="input-lg form-control" id="name" name="name" value="<%=member.getName()%>" placeholder="Nom">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Adresse Email</label>
                                            <input required type="email" class="input-lg form-control" id="email" name="email" value="<%=member.getEmail()%>" placeholder="Adresse Email">
                                        </div>
                                        <div class="form-group">
                                            <label for="birthdate">Date de Naissance</label>

                                            <input required type="date" class="input-lg form-control" id="birthdate" name="birthdate" value="<%=member.getBirthdate()%>" placeholder="Date de Naissance" min="1900-01-01" max="2004-01-01">
                                        </div>
                                        <div class="form-group">
                                            <label for="classname">classeName</label>
                                            <select class="input-lg form-control" id="classname" name="classname">
                                                <%
                                                    List<Class> classes = classService.getAllClasses();
                                                    for(Class classe:classes){
                                                        if(classe.getName().equals(member.getClasse().getName())){
                                                %>
                                                <option selected value="<%=classe.getName()%>"><%=classe.getName()%></option>
                                                <%
                                                    }
                                                    else{
                                                %>
                                                <option  value="<%=classe.getName()%>"><%=classe.getName()%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div><input type="hidden" name="id" value="<%=member.getId()%>"></div>

                                        <div class="text-right">
                                            <button type="submit" class="btn btn-lg btn-primary">Enregistrer</button>
                                        </div>
                                    </form>
                                </div>
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

</html>