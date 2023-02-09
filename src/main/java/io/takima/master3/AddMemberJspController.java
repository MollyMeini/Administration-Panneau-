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
package io.takima.master3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The servlet is registered and mapped to /HelloServlet using the {@linkplain WebServlet
 * @HttpServlet}. The {@link HelloService} is injected by CDI.
 * </p>
 *
 */
@SuppressWarnings("serial")
@WebServlet("/AddMember")
public class AddMemberJspController extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.doGet(req, resp);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthDate = req.getParameter("birthdate");
        String classeName = req.getParameter("classname");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>" + name + "</h1>");
        writer.println("<h1>" + email + "</h1>");
        writer.println("<h1>" + birthDate + "</h1>");
        writer.println("<h1>" + classeName + "</h1>");

        writer.close();
        //if classname exist in the database we report repeat error, otherwise we add into the DB
        if(classeName != null){
            System.out.println(" receive data");
        }else{

        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            RequestDispatcher dispatcher = req.getRequestDispatcher("/add_member.jsp");
            dispatcher.forward(req, resp);
    }

}
