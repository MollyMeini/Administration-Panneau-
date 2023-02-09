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

import services.ClassService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@SuppressWarnings("serial")
@WebServlet("/test")
public class TestCtrl extends HttpServlet {

    ClassService classService = new ClassService();
    public TestCtrl() {
//        String url = "jdbc:postgresql://localhost:5432/pooldb";
//        String password = "mypass";
//        String username = "myuser";
//        PreparedStatement statement = null;
//        try {
//            try {
//                Class.forName("org.postgresql.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("classname"));
        try {
            classService.addClass(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/add_classe.jsp");
        dispatcher.forward(req, resp);

    }

}
