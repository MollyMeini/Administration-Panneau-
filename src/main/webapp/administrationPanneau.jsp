<%@ page import="io.takima.master3.HelloService" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%--charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="fr">

<head>

</head>
<body>
    <%@ include file="./resources/pages/index.html"%>

    <%= ((HelloService)request.getAttribute("helloService")).createHelloMessage("jsp").concat("!!!") %>

    <!-- JSP can also import request attributes: -->
    ${helloService.createHelloMessage("i am right request attribute")}

</body>
    <%@ include file="footer.jsp"%>
</html>
