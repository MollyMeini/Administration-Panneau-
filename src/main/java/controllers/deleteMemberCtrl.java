package controllers;

import services.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteMember")
public class deleteMemberCtrl extends HttpServlet {
    MemberService memberService = new MemberService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        memberService.deleteMember(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/administrationPanneau.jsp");
        dispatcher.forward(req, resp);
    }
}
