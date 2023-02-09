package controllers;

import models.Member;
import services.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateMember")
public class updateMemberCtrl extends HttpServlet {

    MemberService memberService = new MemberService();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        memberService.updateMember(req);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        try {
            req.setAttribute("member", memberService.getMember(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateMember.jsp");
        dispatcher.forward(req, resp);
    }
}
