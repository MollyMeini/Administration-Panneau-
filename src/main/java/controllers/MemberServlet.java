package servlets;

import Services.MemberService;
import io.takima.master3.HelloService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    MemberService memberService = new MemberService();

    @Override
    public void init() {
        System.out.println("Servlet member initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        memberService.addMember(req);
    }

}


