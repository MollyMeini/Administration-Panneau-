package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//JBoss is Full JEE application server and a Servlet Container.

//Tomcat is a Servlet Container.

//The key thing here is the word Container which means that it contains your application and manage the resources it needs and its life-cycle, it offers a context where your application could live and take some advantages or common features required in Enterprise Applications/Web Applications.

public class StarterCtrl extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/administrationPanneau.jsp");
        dispatcher.forward(req, resp);
    }

}

