/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

@SuppressWarnings("serial")
@WebServlet("/AddMember")
public class AddMemberJspController extends HttpServlet {
    private MemberService memberService = new MemberService();
    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String error = memberService.addMember(req);
        if(error.equals("ok")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/administrationPanneau.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            Member member = new Member();
            member.setName(req.getParameter("name"));
            req.setAttribute("error", error);
            req.setAttribute("member", member);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/add_member.jsp");
            dispatcher.forward(req, resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/add_member.jsp");
        dispatcher.forward(req, resp);
    }

}
