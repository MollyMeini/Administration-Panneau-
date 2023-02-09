
<%@ page import="services.ClassService" %>
<%@ page import="models.Member" %>
<%@ page import="services.MemberService" %>
<%@ page import="models.CodeReview" %>
<%@ page import="services.CodeReviewService" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Class" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
    <!--<meta charset="utf-8">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Administration Panel</title>

    <!-- Bootstrap CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./resources/css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>
<style>
    body {
        background-color: black;
        color: white;
        font-family: sans-serif;
        text-align: center;
    }
    #minutes {
        font-size: 500px;
    }
    #seconds {
        font-size: 100px;
    }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script>
    $(function() {

        // Change me!!!
        var seconds = 1 * 60;
        // Change me!!!

        setInterval(function() {
            seconds--;

            if (seconds < (3 * 60))
            {
                $('body').css('background-color', 'red');
                $('body').css('color', 'black');
            }
            else if (seconds < (5 * 60))
            {
                $('body').css('background-color', 'yellow');
                $('body').css('color', 'black');
            }

            $("#minutes").html(Math.floor(seconds/60));
            var secs = seconds % 60;

            $("#seconds").html((secs < 10) ? '0'+secs : secs );
        }, 1000);
    });
</script>

<!-- Change the values here and in the javascript above -->
<div id='minutes'>00</div>
<div id='seconds'>20</div>
<%--<%--%>
<%--    ClassService classService = new ClassService();--%>
<%--    MemberService memberService = new MemberService();--%>
<%--    CodeReviewService codeReviewService = new CodeReviewService();--%>
<%--%>--%>

<%--<div id="wrapper">--%>
<%--    <%@ include file="header.jsp"%>--%>
<%--    <ul class="nav navbar-top-links navbar-right">--%>
<%--        <li class="dropdown">--%>
<%--            <a class="dropdown-toggle navlink" data-toggle="dropdown" href="add_event.jsp">--%>
<%--                <i class="fa fa-gear fa-fw"></i> G&eacute;rer les code reviews <i class="fa fa-caret-down"></i>--%>
<%--            </a>--%>
<%--            <ul class="dropdown-menu dropdown-user">--%>
<%--                <li><a href="AddClasse"><i class="fa fa-users fa-fw"></i> Ajouter une classe</a>--%>
<%--                </li>--%>
<%--                <li><a href="AddMember"><i class="fa fa-user fa-fw"></i> Ajouter un membre</a>--%>
<%--                </li>--%>
<%--                <li><a href="AddEvent"><i class="fa fa-calendar fa-fw"></i> Créer un rendez-vous</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </li>--%>
<%--    </ul>--%>

<%--    <div id="page-wrapper" class="container-fluid">--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-12">--%>
<%--                <h1 class="page-header">Panneau d'Administration</h1>--%>
<%--            </div>--%>
<%--            <!-- /.col-lg-12 -->--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-4 col-md-4">--%>
<%--                <div class="panel panel-primary">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-xs-3">--%>
<%--                                <i class="fa fa-users fa-5x"></i>--%>
<%--                            </div>--%>
<%--                            <div class="col-xs-9 text-right">--%>

<%--                                <div class="huge"><%=classService.getAllClasses().size()%></div>--%>
<%--                                <div class="huge-label">classes</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <a href="add_classe.jsp">--%>
<%--                        <div class="panel-footer">--%>
<%--                            <span class="pull-left">Ajouter une classe</span>--%>
<%--                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>--%>
<%--                            <div class="clearfix"></div>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-4">--%>
<%--                <div class="panel panel-green">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-xs-3">--%>
<%--                                <i class="fa fa-user fa-5x"></i>--%>
<%--                            </div>--%>
<%--                            <div class="col-xs-9 text-right">--%>
<%--                                <div class="huge"><%=memberService.getAllMembers().size()%></div>--%>
<%--                                <div class="huge-label">Membres inscrits</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <a href="add_member.jsp">--%>
<%--                        <div class="panel-footer">--%>
<%--                            <span class="pull-left">Ajouter un membre</span>--%>
<%--                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>--%>
<%--                            <div class="clearfix"></div>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4 col-md-4">--%>
<%--                <div class="panel panel-yellow">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-xs-3">--%>
<%--                                <i class="fa fa-calendar fa-5x"></i>--%>
<%--                            </div>--%>
<%--                            <div class="col-xs-9 text-right">--%>
<%--                                <div class="huge"><%=codeReviewService.getAllCodeReviews().size()%></div>--%>
<%--                                <div class="huge-label">Code reviews programmées</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <a href="add_event.jsp">--%>
<%--                        <div class="panel-footer">--%>
<%--                            <span class="pull-left">Ajouter une code review</span>--%>
<%--                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>--%>
<%--                            <div class="clearfix"></div>--%>
<%--                        </div>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--        <div class="row">--%>
<%--            <div class="col-lg-8">--%>
<%--                <!-- /.panel -->--%>
<%--                <div class="panel panel-default">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <i class="fa fa-user fa-fw"></i> Gestion des membres--%>
<%--                    </div>--%>
<%--                    <!-- /.panel-heading -->--%>
<%--                    <div class="panel-body">--%>
<%--                        <div class="row">--%>
<%--                            <div class="col-lg-12">--%>
<%--                                <div class="table-responsive">--%>
<%--                                    <table class="table table-hover table-striped">--%>
<%--                                        <thead>--%>
<%--                                        <tr>--%>
<%--                                            <th>Nom</th>--%>
<%--                                            <th>Email</th>--%>
<%--&lt;%&ndash;                                            <th>Date de Naissance</th>&ndash;%&gt;--%>
<%--                                            <th>classe</th>--%>
<%--                                            <th class="text-right">Action</th>--%>
<%--                                        </tr>--%>
<%--                                        </thead>--%>

<%--                                        <tbody>--%>
<%--                                        <%  ;--%>
<%--                                            List<Member> members = memberService.getAllMembers();--%>
<%--                                            for(Member member:members){--%>
<%--                                        %>--%>
<%--                                        <tr>--%>

<%--                                            <td><%= member.getName()%></td>--%>
<%--                                            <td><%= member.getEmail()%></td>--%>
<%--                                            <td><%= member.getClasse().getName()%></td>--%>
<%--                                            <td  class="text-right">--%>
<%--                                                <a href="<%= request.getContextPath() %>/updateMember?id=<%=member.getId()%>" class="btn btn-sm btn-warning"><i class="fa fa-pencil"></i> Modifier</a>--%>
<%--                                                <a href="<%= request.getContextPath() %>/deleteMember?id=<%=member.getId()%>" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Supprimer</a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>

<%--                                        <%  } %>--%>
<%--                                        </tbody>--%>
<%--                                    </table>--%>
<%--&lt;%&ndash;                                    <div class="text-center">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        <ul class="pagination">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <li><a href="#">1</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <li><a href="#">2</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <li><a href="#">3</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--                                </div>--%>
<%--                                <!-- /.table-responsive -->--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /.row -->--%>
<%--                    </div>--%>
<%--                    <!-- /.panel-body -->--%>
<%--                </div>--%>
<%--                <!-- /.panel -->--%>
<%--            </div>--%>
<%--            <!-- /.col-lg-8 -->--%>
<%--            <div class="col-lg-4">--%>
<%--                <div class="panel panel-default">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <i class="fa fa-calendar fa-fw"></i> Codes reviews programmées--%>
<%--                    </div>--%>
<%--                    <div class="panel-body">--%>
<%--                        <table class="table table-striped">--%>
<%--                            <%--%>
<%--                                List<CodeReview> codeReviews = codeReviewService.getAllCodeReviews();--%>
<%--                                for(CodeReview codeReview:codeReviews){--%>
<%--                            %>--%>
<%--                            <tr>--%>
<%--                                <td><%= codeReview.getName()%></td>--%>
<%--                                <td><%= codeReview.getClasse().getName()%></td>--%>
<%--                                <td class="text-right"><span class="text-muted small"><%= codeReview.getDatetime()%></span></td>--%>
<%--                            </tr>--%>
<%--                            <%  } %>--%>

<%--                        </table>--%>
<%--                        <a href=add_event.jsp class="btn btn-default btn-block">Programmer une code review</a>--%>
<%--                    </div>--%>
<%--                    <!-- /.panel-body -->--%>
<%--                </div>--%>
<%--                <!-- /.panel -->--%>

<%--                <div class="panel panel-default">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <i class="fa fa-users fa-fw"></i> Gestion des classes--%>
<%--                    </div>--%>
<%--                    <!-- /.panel-heading -->--%>
<%--                    <div class="panel-body">--%>
<%--                        <div class="list-group">--%>
<%--                            <%--%>
<%--                                List<Class> classes = classService.getAllClasses();--%>
<%--                                for(Class classe:classes){--%>
<%--                            %>--%>
<%--                            <a href="#" class="list-group-item">--%>

<%--                                <i class="fa fa-users fa-fw"></i> <%= classe.getName()%>--%>
<%--                                <span class="pull-right text-muted small"><em><%= classe.getNmembres()%> membres</em>--%>
<%--                                    </span>--%>
<%--                            </a>--%>
<%--                            <%  } %>--%>
<%--                        </div>--%>
<%--                        <!-- /.list-group -->--%>
<%--                        <a href="add_classe.jsp" class="btn btn-default btn-block">Cr&eacute;er une nouvelle classe</a>--%>
<%--                    </div>--%>
<%--                    <!-- /.panel-body -->--%>
<%--                </div>--%>
<%--                <!-- /.panel -->--%>
<%--            </div>--%>
<%--            <!-- /.col-lg-4 -->--%>
<%--        </div>--%>
<%--        <!-- /.row -->--%>
<%--    </div>--%>
<%--    <!-- /#page-wrapper -->--%>

<%--</div>--%>

<%--<!-- jQuery -->--%>
<%--<script src="../js/jquery-3.1.1.min.js"></script>--%>

<%--<!-- Bootstrap Core JavaScript -->--%>
<%--<script src="../js/bootstrap.min.js"></script>--%>

</body>
<%@ include file="footer.jsp"%>
</html>

