package controllers;

import models.Member;
import services.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateMember")
public class updateMemberCtrl extends HttpServlet {

    MemberService memberService = new MemberService();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        memberService.updateMember(req);
    }
}
